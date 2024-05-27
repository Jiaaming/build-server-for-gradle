// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

/**
 * GetBuildReply.
 
 */
public class GetBuildReply {
  private BuildKind kind;
  private Progress progress;
  private Output output;
  private Cancelled cancelled;
  private Environment environment;
  private String compatibilityCheckError;
  private GetBuildResult getBuildResult;

  public GetBuildReply() {
  }

  // Getters and Setters
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

  public GetBuildResult getGetBuildResult() {
    return getBuildResult;
  }

  public void setGetBuildResult(GetBuildResult getBuildResult) {
    this.getBuildResult = getBuildResult;
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
