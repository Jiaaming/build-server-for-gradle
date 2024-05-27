// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.plugin;


import java.io.Serializable;

import com.microsoft.java.bs.core.internal.gradle.api.GradleField;

/**
 * Represents a field in a Gradle closure.
 */
public class DefaultGradleField implements Serializable, GradleField {
  private String name;
  private boolean deprecated;

  public DefaultGradleField(String name, boolean deprecated) {
    this.name = name;
    this.deprecated = deprecated;
  }

  public String getName() {
    return this.name;
  }

  public boolean getDeprecated() {
    return this.deprecated;
  }
}
