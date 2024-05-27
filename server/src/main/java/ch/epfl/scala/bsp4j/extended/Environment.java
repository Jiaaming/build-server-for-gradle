// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

import java.util.Objects;

/**
 * Environment.
 */
public class Environment {
  private GradleEnvironment gradleEnvironment;
  private JavaEnvironment javaEnvironment;

  public Environment() {
  }

  private Environment(Builder builder) {
    this.gradleEnvironment = builder.gradleEnvironment;
    this.javaEnvironment = builder.javaEnvironment;
  }

  public Environment(GradleEnvironment gradleEnvironment, JavaEnvironment javaEnvironment) {
    this.gradleEnvironment = gradleEnvironment;
    this.javaEnvironment = javaEnvironment;
  }

  public GradleEnvironment getGradleEnvironment() {
    return gradleEnvironment;
  }

  public void setGradleEnvironment(GradleEnvironment gradleEnvironment) {
    this.gradleEnvironment = gradleEnvironment;
  }

  public JavaEnvironment getJavaEnvironment() {
    return javaEnvironment;
  }

  public void setJavaEnvironment(JavaEnvironment javaEnvironment) {
    this.javaEnvironment = javaEnvironment;
  }

  @Override
  public int hashCode() {
    return Objects.hash(gradleEnvironment, javaEnvironment);
  }

  /**
   * Builder for Environment.
   */
  public static class Builder {
    private GradleEnvironment gradleEnvironment;
    private JavaEnvironment javaEnvironment;

    public Builder setGradleEnvironment(GradleEnvironment gradleEnvironment) {
      this.gradleEnvironment = gradleEnvironment;
      return this;
    }

    public Builder setJavaEnvironment(JavaEnvironment javaEnvironment) {
      this.javaEnvironment = javaEnvironment;
      return this;
    }

    public Environment build() {
      return new Environment(this);
    }
  }
}
