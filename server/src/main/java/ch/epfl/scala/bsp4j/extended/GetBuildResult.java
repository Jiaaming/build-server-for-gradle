// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.
package ch.epfl.scala.bsp4j.extended;

public class GetBuildResult {
    private BuildKind kind;
    private Progress progress;
    private Output output;
    private Cancelled cancelled;
    private BuildResult getBuildResult;
    private Environment environment;
    private String compatibilityCheckError;

    public GetBuildResult() {}

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

    public BuildResult getGetBuildResult() {
      return getBuildResult;
    }

    public void setGetBuildResult(BuildResult getBuildResult) {
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
