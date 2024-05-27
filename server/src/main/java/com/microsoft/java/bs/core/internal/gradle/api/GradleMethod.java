// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.api;

import java.util.List;

/**
 * Represents a method in a Gradle closure.
 
 */
public interface GradleMethod {
  String getName();

  List<String> getParameterTypes();

  boolean getDeprecated();
}
