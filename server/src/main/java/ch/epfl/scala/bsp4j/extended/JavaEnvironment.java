// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaEnvironment.
 
 */
public class JavaEnvironment {
  private String javaHome;
  private List<String> jvmArgs;

  public JavaEnvironment() {
  }

  public JavaEnvironment(String javaHome, List<String> jvmArgs) {
    this.javaHome = javaHome;
    this.jvmArgs = jvmArgs;
  }

  public String getJavaHome() {
    return javaHome;
  }

  public void setJavaHome(String javaHome) {
    this.javaHome = javaHome;
  }

  public List<String> getJvmArgs() {
    return jvmArgs;
  }

  public void setJvmArgs(List<String> jvmArgs) {
    this.jvmArgs = jvmArgs;
  }

  /**
   * Builder for JavaEnvironment.
   */
  public static class Builder {
    private String javaHome;
    private List<String> jvmArgs = new ArrayList<>();

    public Builder setJavaHome(String javaHome) {
      this.javaHome = javaHome;
      return this;
    }

    public Builder addJvmArg(String jvmArg) {
      this.jvmArgs.add(jvmArg);
      return this;
    }

    public Builder addAllJvmArgs(List<String> jvmArgs) {
      this.jvmArgs.addAll(jvmArgs);
      return this;
    }

    public JavaEnvironment build() {
      return new JavaEnvironment(javaHome, jvmArgs);
    }
  }
}
