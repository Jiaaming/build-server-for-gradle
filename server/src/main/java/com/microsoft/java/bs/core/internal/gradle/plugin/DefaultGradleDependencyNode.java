// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.plugin;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.java.bs.core.internal.gradle.api.GradleDependencyNode;
import com.microsoft.java.bs.core.internal.gradle.api.GradleDependencyType;

/**
 * Default implementation of {@link GradleDependencyNode}.
 */
public class DefaultGradleDependencyNode implements GradleDependencyNode, Serializable {
  private String name;
  private GradleDependencyType type;
  private List<GradleDependencyNode> children;

  /**
   * Constructor.
   */
  public DefaultGradleDependencyNode(String name, 
      GradleDependencyType type, List<GradleDependencyNode> children) {
    this.name = name;
    this.type = type;
    this.children = children;
  }

  /**
   * Constructor.
   */
  public DefaultGradleDependencyNode(String name, 
      GradleDependencyType type) {
    this.name = name;
    this.type = type;
    this.children = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GradleDependencyType getType() {
    return this.type;
  }

  public void setType(GradleDependencyType type) {
    this.type = type;
  }

  public List<GradleDependencyNode> getChildren() {
    return this.children;
  }

  public void setChildren(List<GradleDependencyNode> children) {
    this.children = children;
  }

  public void addChildren(GradleDependencyNode child) {
    this.children.add(child);
  }
}
