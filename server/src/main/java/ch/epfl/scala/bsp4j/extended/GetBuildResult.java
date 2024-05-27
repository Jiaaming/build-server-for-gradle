// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

/**
 * GetBuildResult.
 
 */
public class GetBuildResult {
  private BuildKind kind;
  private Progress progress;
  private Output output;
  private Cancelled cancelled;
  private Environment environment;
  private String compatibilityCheckError;

  private boolean success;
  private String message;
  private GradleProject project;

  // Getters and setters
  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public GradleProject getProject() {
    return project;
  }

  public void setProject(GradleProject project) {
    this.project = project;
  }

  public BuildKind getKind() {
    return kind;
  }

  public void setKind(BuildKind kind) {
    this.kind = kind;
  }

  public Progress getProgress() {
    return progress;
  }

  public void setProgress(Progress progress) {
    this.progress = progress;
  }

  public Output getOutput() {
    return output;
  }

  public void setOutput(Output output) {
    this.output = output;
  }

  public Cancelled getCancelled() {
    return cancelled;
  }

  public void setCancelled(Cancelled cancelled) {
    this.cancelled = cancelled;
  }

  public Environment getEnvironment() {
    return environment;
  }

  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  public String getCompatibilityCheckError() {
    return compatibilityCheckError;
  }

  public void setCompatibilityCheckError(String compatibilityCheckError) {
    this.compatibilityCheckError = compatibilityCheckError;
  }

}
