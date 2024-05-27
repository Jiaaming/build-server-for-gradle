// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.plugin;

import java.io.Serializable;
import java.util.List;

import com.microsoft.java.bs.core.internal.gradle.api.GradleMethod;

/**
 * Represents a method in a Gradle closure.
 */
public class DefaultGradleMethod implements Serializable, GradleMethod {
  private String name;
  private List<String> parameterTypes;
  private boolean deprecated;

  /**
   * Constructor.
   */
  public DefaultGradleMethod(String name, List<String> parameterTypes, boolean deprecated) {
    this.name = name;
    this.parameterTypes = parameterTypes;
    this.deprecated = deprecated;
  }

  public String getName() {
    return this.name;
  }

  public List<String> getParameterTypes() {
    return this.parameterTypes;
  }

  public boolean getDeprecated() {
    return this.deprecated;
  }
}
