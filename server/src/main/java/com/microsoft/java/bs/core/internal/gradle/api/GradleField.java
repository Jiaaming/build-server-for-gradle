// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.api;

/**
 * Represents a field in a Gradle closure.
 */
public interface GradleField {
  String getName();

  boolean getDeprecated();
}
