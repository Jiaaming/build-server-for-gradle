// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.api;

import java.util.List;

/**
 * Represents a Gradle closure.
 */
public interface GradleClosure {
  String getName();

  List<GradleMethod> getMethods();

  List<GradleField> getFields();
}
