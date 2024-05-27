// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.plugin;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.microsoft.java.bs.core.internal.gradle.api.GradleClosure;
import com.microsoft.java.bs.core.internal.gradle.api.GradleField;
import com.microsoft.java.bs.core.internal.gradle.api.GradleMethod;

/**
 * Default implementation of {@link GradleClosure}.
 
 */
public class DefaultGradleClosure implements GradleClosure, Serializable {
  private String name;
  private List<GradleMethod> methods;
  private List<GradleField> fields;

  /**
   * Constructor.
   */
  public DefaultGradleClosure(String name, List<GradleMethod> methods, List<GradleField> fields) {
    this.name = name;
    this.methods = methods;
    this.fields = fields;
  }

  public DefaultGradleClosure(String name, List<GradleMethod> methods) {
    this(name, methods, Collections.emptyList());
  }

  public String getName() {
    return this.name;
  }

  public List<GradleMethod> getMethods() {
    return this.methods;
  }

  public List<GradleField> getFields() {
    return this.fields;
  }
}
