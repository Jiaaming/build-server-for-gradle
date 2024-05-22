package ch.epfl.scala.bsp4j.extended;

public class BuildResult {
    private Project project;

    public BuildResult() {}

    public BuildResult(Project project) {
      this.project = project;
    }

    // Getters and Setters
    public Project getProject() {
      return project;
    }

    public void setProject(Project project) {
      this.project = project;
    }
  }
