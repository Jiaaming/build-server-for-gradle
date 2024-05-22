package ch.epfl.scala.bsp4j.extended;

import java.util.List;

public class Project {
    private boolean isRoot;
    private List<Task> tasks;
    private List<Project> projects;
    private String projectPath;
    private DependencyItem dependencyItem;
    private List<Plugin> plugins;
    private List<PluginClosure> pluginClosures;
    private List<String> scriptClasspaths;

    public Project() {}

    public Project(boolean isRoot, List<Task> tasks, List<Project> projects, String projectPath, DependencyItem dependencyItem, List<Plugin> plugins, List<PluginClosure> pluginClosures, List<String> scriptClasspaths) {
      this.isRoot = isRoot;
      this.tasks = tasks;
      this.projects = projects;
      this.projectPath = projectPath;
      this.dependencyItem = dependencyItem;
      this.plugins = plugins;
      this.pluginClosures = pluginClosures;
      this.scriptClasspaths = scriptClasspaths;
    }

    public boolean isRoot() {
      return isRoot;
    }

    public void setRoot(boolean isRoot) {
      this.isRoot = isRoot;
    }

    public List<Task> getTasks() {
      return tasks;
    }

    public void setTasks(List<Task> tasks) {
      this.tasks = tasks;
    }

    public List<Project> getProjects() {
      return projects;
    }

    public void setProjects(List<Project> projects) {
      this.projects = projects;
    }

    public String getProjectPath() {
      return projectPath;
    }

    public void setProjectPath(String projectPath) {
      this.projectPath = projectPath;
    }

    public DependencyItem getDependencyItem() {
      return dependencyItem;
    }

    public void setDependencyItem(DependencyItem dependencyItem) {
      this.dependencyItem = dependencyItem;
    }

    public List<Plugin> getPlugins() {
      return plugins;
    }

    public void setPlugins(List<Plugin> plugins) {
      this.plugins = plugins;
    }

    public List<PluginClosure> getPluginClosures() {
      return pluginClosures;
    }

    public void setPluginClosures(List<PluginClosure> pluginClosures) {
      this.pluginClosures = pluginClosures;
    }

    public List<String> getScriptClasspaths() {
      return scriptClasspaths;
    }

    public void setScriptClasspaths(List<String> scriptClasspaths) {
      this.scriptClasspaths = scriptClasspaths;
    }
  }
