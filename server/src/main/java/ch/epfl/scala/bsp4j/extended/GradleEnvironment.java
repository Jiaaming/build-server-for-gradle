// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

/**
 * GradleEnvironment.
 
 */
public class GradleEnvironment {
  private String gradleUserHome;
  private String gradleVersion;

  public GradleEnvironment() {
  }

  public GradleEnvironment(String gradleUserHome, String gradleVersion) {
    this.gradleUserHome = gradleUserHome;
    this.gradleVersion = gradleVersion;
  }

  public String getGradleUserHome() {
    return gradleUserHome;
  }

  public void setGradleUserHome(String gradleUserHome) {
    this.gradleUserHome = gradleUserHome;
  }

  public String getGradleVersion() {
    return gradleVersion;
  }

  public void setGradleVersion(String gradleVersion) {
    this.gradleVersion = gradleVersion;
  }

  /**
   * Builder for GradleEnvironment.
   */
  public static class Builder {
    private String gradleUserHome;
    private String gradleVersion;

    public Builder setGradleUserHome(String gradleUserHome) {
      this.gradleUserHome = gradleUserHome;
      return this;
    }

    public Builder setGradleVersion(String gradleVersion) {
      this.gradleVersion = gradleVersion;
      return this;
    }

    public GradleEnvironment build() {
      return new GradleEnvironment(gradleUserHome, gradleVersion);
    }
  }
}
