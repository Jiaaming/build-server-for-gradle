// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.handlers;

import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ModelBuilder;
import org.gradle.tooling.ProjectConnection;
import org.gradle.tooling.events.OperationType;
import org.gradle.tooling.model.build.BuildEnvironment;
import com.google.common.base.Strings;
import com.microsoft.java.bs.core.internal.gradle.GradleProjectConnector;
import com.microsoft.java.bs.core.internal.gradle.ByteBufferOutputStream;
import com.microsoft.java.bs.core.internal.gradle.GradleBuildCancellation;

import ch.epfl.scala.bsp4j.extended.GetBuildParams;
import ch.epfl.scala.bsp4j.extended.Environment;
import ch.epfl.scala.bsp4j.extended.GetBuildResult;
// import ch.epfl.scala.bsp4j.extended.Progress;
// import ch.epfl.scala.bsp4j.extended.BuildKind;
// import ch.epfl.scala.bsp4j.extended.Cancelled;
import ch.epfl.scala.bsp4j.extended.DependencyItem;
import ch.epfl.scala.bsp4j.extended.GradleProject;
import ch.epfl.scala.bsp4j.extended.PluginClosure;
import ch.epfl.scala.bsp4j.extended.PluginField;
import ch.epfl.scala.bsp4j.extended.PluginMethod;
import ch.epfl.scala.bsp4j.extended.GradleTask;
import ch.epfl.scala.bsp4j.extended.GradleEnvironment;
import ch.epfl.scala.bsp4j.extended.JavaEnvironment;

import com.microsoft.java.bs.core.internal.gradle.api.GradleDependencyNode;
import com.microsoft.java.bs.core.internal.gradle.api.GradleModelAction;
import com.microsoft.java.bs.core.internal.gradle.api.GradleProjectModel;
import com.microsoft.java.bs.core.internal.utils.PluginUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.gradle.tooling.BuildActionExecuter;
import org.gradle.tooling.CancellationToken;
import org.gradle.tooling.events.ProgressListener;

/**
 * GetBuildHandler.
 */
public class GetBuildHandler {
  private GetBuildParams params;
  private Environment environment;
  private ProgressListener progressListener;
  private ByteBufferOutputStream standardOutputListener;
  private ByteBufferOutputStream standardErrorListener;

  public GetBuildHandler(GetBuildParams params) {
    this.params = params;
  }

  /**
   * Run the handler.
   *
   * @return the result
   */
  public GetBuildResult run() {
    GetBuildResult getBuildResult = new GetBuildResult();
    GradleConnector gradleConnector = GradleProjectConnector
        .build(params.getProjectDir(), params.getGradleConfig());
    try (ProjectConnection connection = gradleConnector.connect()) {
      this.environment = buildEnvironment(connection);
      BuildActionExecuter<GradleProjectModel> action = connection.action(new GradleModelAction());

      if (action == null) {
        getBuildResult.setSuccess(false);
        getBuildResult.setMessage("Action is null");
        return getBuildResult;
      }
      getBuildResult.setEnvironment(environment);

      List<String> arguments = new ArrayList<>();
      String debugPlugin = System.getenv("VSCODE_DEBUG_PLUGIN");
      if ("true".equals(debugPlugin)) {
        arguments.add("-Dorg.gradle.debug=true");
      }
      File initScript = PluginUtils.getInitScript();
      if (initScript != null) {
        arguments.addAll(Arrays.asList("--init-script", initScript.getAbsolutePath()));
      }
      String jvmArguments = params.getGradleConfig().getJvmArguments();
      if (!Strings.isNullOrEmpty(jvmArguments)) {
        arguments.addAll(Arrays.stream(jvmArguments.split(" "))
            .filter(e -> e != null && !e.isEmpty())
            .collect(Collectors.toList()));
      }
      action.withArguments(arguments);

      CancellationToken cancellationToken = GradleBuildCancellation
          .buildToken(params.getCancellationKey());
      Set<OperationType> progressEvents = new HashSet<>();
      progressEvents.add(OperationType.PROJECT_CONFIGURATION);
      action.withCancellationToken(cancellationToken)
          .addProgressListener(progressListener, progressEvents)
          .setStandardOutput(standardOutputListener).setStandardError(standardErrorListener)
          .setColorOutput(params.getShowOutputColors());
      // Perform build steps
      GradleProjectModel gradleModel = action.run();

      if (gradleModel == null) {
        throw new Exception("Error occurs in querying custom model.");
      }

      GradleProject project = getProjectData(gradleModel);

      getBuildResult.setSuccess(true);
      getBuildResult.setProject(project);
      getBuildResult.setMessage("Build completed successfully.");
      return getBuildResult;
    } catch (Exception e) {
      getBuildResult.setSuccess(false);
      getBuildResult.setMessage("Build failed: " + e.getMessage());
      return getBuildResult;
    } finally {
      GradleBuildCancellation.clearToken(params.getCancellationKey());
    }
  }

  private Environment buildEnvironment(ProjectConnection connection) {
    ModelBuilder<BuildEnvironment> buildEnvironment = connection.model(BuildEnvironment.class);

    Set<OperationType> progressEvents = new HashSet<>();
    progressEvents.add(OperationType.GENERIC);

    CancellationToken cancellationToken = GradleBuildCancellation
        .buildToken(params.getCancellationKey());

    buildEnvironment
        .withCancellationToken(cancellationToken)
        .addProgressListener(progressListener, progressEvents)
        .setStandardOutput(standardOutputListener).setStandardError(standardErrorListener)
        .setColorOutput(params.getShowOutputColors());
    String jvmArguments = params.getGradleConfig().getJvmArguments();
    if (!Strings.isNullOrEmpty(jvmArguments)) {
      buildEnvironment.setJvmArguments(Arrays.stream(jvmArguments.split(" "))
          .filter(e -> e != null && !e.isEmpty()).toArray(String[]::new));
    }

    try {
      BuildEnvironment environment = buildEnvironment.get();
      org.gradle.tooling.model.build.GradleEnvironment gradleEnvironment = environment.getGradle();
      org.gradle.tooling.model.build.JavaEnvironment javaEnvironment = environment.getJava();

      return new Environment.Builder()
          .setGradleEnvironment(new GradleEnvironment.Builder()
              .setGradleUserHome(gradleEnvironment.getGradleUserHome().getAbsolutePath())
              .setGradleVersion(gradleEnvironment.getGradleVersion())
              .build())
          .setJavaEnvironment(new JavaEnvironment.Builder()
              .setJavaHome(javaEnvironment.getJavaHome().getAbsolutePath())
              .addAllJvmArgs(javaEnvironment.getJvmArguments())
              .build())
          .build();
    } finally {
      GradleBuildCancellation.clearToken(params.getCancellationKey());
    }
  }

  private GradleProject getProjectData(GradleProjectModel gradleModel) {
    List<GradleTask> tasks = getGradleTasks(gradleModel);
    List<GradleProject> subProjects = new ArrayList<>();
    for (GradleProjectModel subProjectModel : gradleModel.getSubProjects()) {
      subProjects.add(getProjectData(subProjectModel));
    }
    List<String> plugins = gradleModel.getPlugins();
    List<PluginClosure> pluginClosures = getPluginClosures(gradleModel);
    List<String> scriptClasspaths = gradleModel.getScriptClasspaths();

    return new GradleProject.Builder()
        .setIsRoot(gradleModel.getIsRoot())
        .setTasks(tasks)
        .setProjects(subProjects)
        .setProjectPath(gradleModel.getProjectPath())
        .setDependencyItem(getDependencyItem(gradleModel.getDependencyNode()))
        .setPlugins(plugins)
        .setPluginClosures(pluginClosures)
        .setScriptClasspaths(scriptClasspaths)
        .build();
  }

  private List<GradleTask> getGradleTasks(GradleProjectModel model) {
    List<GradleTask> tasks = new ArrayList<>();
    model.getTasks().forEach(task -> {
      GradleTask.Builder builder = new GradleTask.Builder();
      builder.setName(task.getName())
          .setPath(task.getPath())
          .setProject(task.getProject())
          .setBuildFile(task.getBuildFile())
          .setRootProject(task.getRootProject())
          .setDebuggable(task.getDebuggable());

      String group = task.getGroup();
      if (group != null) {
        builder.setGroup(group);
      }

      String description = task.getDescription();
      if (description != null) {
        builder.setDescription(description);
      }

      tasks.add(builder.build());
    });
    return tasks;
  }

  private DependencyItem getDependencyItem(GradleDependencyNode node) {
    DependencyItem.Builder builder = new DependencyItem.Builder();
    builder.setName(node.getName());
    builder.setType(node.getType());

    if (node.getChildren() != null) {
      List<DependencyItem> children = new ArrayList<>();
      for (GradleDependencyNode child : node.getChildren()) {
        children.add(getDependencyItem(child));
      }
      builder.addAllChildren(children);
    }
    return builder.build();
  }

  private List<PluginClosure> getPluginClosures(GradleProjectModel model) {
    List<PluginClosure> pluginClosures = new ArrayList<>();
    model.getClosures().forEach(closure -> {
      List<PluginMethod> methods = new ArrayList<>();
      closure.getMethods().forEach(method -> {
        methods.add(new PluginMethod(
            method.getName(),
            method.getParameterTypes(),
            method.getDeprecated()));
      });

      List<PluginField> fields = new ArrayList<>();
      closure.getFields().forEach(field -> {
        fields.add(new PluginField(
            field.getName(),
            field.getDeprecated()));
      });

      PluginClosure pluginClosure = new PluginClosure(
          closure.getName(),
          methods,
          fields);
      pluginClosures.add(pluginClosure);
    });
    return pluginClosures;
  }

}
