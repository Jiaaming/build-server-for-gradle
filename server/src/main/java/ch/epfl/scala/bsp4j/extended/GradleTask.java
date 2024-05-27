package ch.epfl.scala.bsp4j.extended;

/**
 * Represents a Gradle task.
 
 */
public class GradleTask {
  private String name;
  private String group;
  private String path;
  private String project;
  private String buildFile;
  private String rootProject;
  private String description;
  private boolean debuggable;

  // Getters and Setters

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public String getBuildFile() {
    return buildFile;
  }

  public void setBuildFile(String buildFile) {
    this.buildFile = buildFile;
  }

  public String getRootProject() {
    return rootProject;
  }

  public void setRootProject(String rootProject) {
    this.rootProject = rootProject;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isDebuggable() {
    return debuggable;
  }

  public void setDebuggable(boolean debuggable) {
    this.debuggable = debuggable;
  }

  /**
   * Builder for GradleTask.
   */
  public static class Builder {
    private String name;
    private String group;
    private String path;
    private String project;
    private String buildFile;
    private String rootProject;
    private String description;
    private boolean debuggable;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setGroup(String group) {
      this.group = group;
      return this;
    }

    public Builder setPath(String path) {
      this.path = path;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setBuildFile(String buildFile) {
      this.buildFile = buildFile;
      return this;
    }

    public Builder setRootProject(String rootProject) {
      this.rootProject = rootProject;
      return this;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Builder setDebuggable(boolean debuggable) {
      this.debuggable = debuggable;
      return this;
    }

    /**
     * Build the GradleTask object.
     */
    public GradleTask build() {
      GradleTask task = new GradleTask();
      task.setName(this.name);
      task.setGroup(this.group);
      task.setPath(this.path);
      task.setProject(this.project);
      task.setBuildFile(this.buildFile);
      task.setRootProject(this.rootProject);
      task.setDescription(this.description);
      task.setDebuggable(this.debuggable);
      return task;
    }
  }
}
