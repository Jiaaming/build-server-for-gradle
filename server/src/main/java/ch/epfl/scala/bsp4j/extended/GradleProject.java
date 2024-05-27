package ch.epfl.scala.bsp4j.extended;

import java.util.List;

/**
 * Represents a Gradle project.
 
 */
public class GradleProject {
  private boolean isRoot;
  private List<GradleTask> tasks;
  private List<GradleProject> projects;
  private String projectPath;
  private DependencyItem dependencyItem;
  private List<String> plugins;
  private List<PluginClosure> pluginClosures;
  private List<String> scriptClasspaths;

  private GradleProject(Builder builder) {
    this.isRoot = builder.isRoot;
    this.tasks = builder.tasks;
    this.projects = builder.projects;
    this.projectPath = builder.projectPath;
    this.dependencyItem = builder.dependencyItem;
    this.plugins = builder.plugins;
    this.pluginClosures = builder.pluginClosures;
    this.scriptClasspaths = builder.scriptClasspaths;
  }

  public boolean isRoot() {
    return isRoot;
  }

  public List<GradleTask> getTasks() {
    return tasks;
  }

  public List<GradleProject> getProjects() {
    return projects;
  }

  public String getProjectPath() {
    return projectPath;
  }

  public DependencyItem getDependencyItem() {
    return dependencyItem;
  }

  public List<String> getPlugins() {
    return plugins;
  }

  public List<PluginClosure> getPluginClosures() {
    return pluginClosures;
  }

  public List<String> getScriptClasspaths() {
    return scriptClasspaths;
  }

  /**
   * Builder for GradleProject.
   */
  public static class Builder {
    private boolean isRoot;
    private List<GradleTask> tasks;
    private List<GradleProject> projects;
    private String projectPath;
    private DependencyItem dependencyItem;
    private List<String> plugins;
    private List<PluginClosure> pluginClosures;
    private List<String> scriptClasspaths;

    public Builder() {
    }

    public Builder setIsRoot(boolean isRoot) {
      this.isRoot = isRoot;
      return this;
    }

    public Builder setTasks(List<GradleTask> tasks) {
      this.tasks = tasks;
      return this;
    }

    public Builder setProjects(List<GradleProject> projects) {
      this.projects = projects;
      return this;
    }

    public Builder setProjectPath(String projectPath) {
      this.projectPath = projectPath;
      return this;
    }

    public Builder setDependencyItem(DependencyItem dependencyItem) {
      this.dependencyItem = dependencyItem;
      return this;
    }

    public Builder setPlugins(List<String> plugins) {
      this.plugins = plugins;
      return this;
    }

    public Builder setPluginClosures(List<PluginClosure> pluginClosures) {
      this.pluginClosures = pluginClosures;
      return this;
    }

    public Builder setScriptClasspaths(List<String> scriptClasspaths) {
      this.scriptClasspaths = scriptClasspaths;
      return this;
    }

    public GradleProject build() {
      return new GradleProject(this);
    }
  }
}
