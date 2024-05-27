package ch.epfl.scala.bsp4j.extended;

import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

/**
 * The request is sent from the client to the server to get the build parameters.
 */
public class GetBuildParams {
  @NonNull
  private String projectDir;
  @NonNull
  private String cancellationKey;
  @NonNull
  private GradleConfig gradleConfig;
  private boolean showOutputColors;

  public GetBuildParams() {}

  /**
  * Constructor for GetBuildParams.
  */
  public GetBuildParams(@NonNull String projectDir, @NonNull String cancellationKey, 
      @NonNull GradleConfig gradleConfig, boolean showOutputColors) {
    this.projectDir = projectDir;
    this.cancellationKey = cancellationKey;
    this.gradleConfig = gradleConfig;
    this.showOutputColors = showOutputColors;
  }

  // Getters and Setters
  @NonNull
  public String getProjectDir() {
    return projectDir;
  }

  public void setProjectDir(@NonNull String projectDir) {
    this.projectDir = projectDir;
  }

  @NonNull
  public String getCancellationKey() {
    return cancellationKey;
  }

  public void setCancellationKey(@NonNull String cancellationKey) {
    this.cancellationKey = cancellationKey;
  }

  @NonNull
  public GradleConfig getGradleConfig() {
    return gradleConfig;
  }

  public void setGradleConfig(@NonNull GradleConfig gradleConfig) {
    this.gradleConfig = gradleConfig;
  }

  public boolean isShowOutputColors() {
    return showOutputColors;
  }

  public void setShowOutputColors(boolean showOutputColors) {
    this.showOutputColors = showOutputColors;
  }

  public boolean getShowOutputColors() {
    return this.showOutputColors;
  }
}

