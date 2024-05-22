package ch.epfl.scala.bsp4j.extended;

public class Cancelled {
    private String message;
    private String projectDir;

    public Cancelled() {}

    public Cancelled(String message, String projectDir) {
      this.message = message;
      this.projectDir = projectDir;
    }

    // Getters and Setters
    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public String getProjectDir() {
      return projectDir;
    }

    public void setProjectDir(String projectDir) {
      this.projectDir = projectDir;
    }
  }
