// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.api;

import java.util.List;

/**
 * Represents a node in the dependency tree.
 
 */
public interface GradleDependencyNode {
  String getName();

  GradleDependencyType getType();

  List<GradleDependencyNode> getChildren();
}
