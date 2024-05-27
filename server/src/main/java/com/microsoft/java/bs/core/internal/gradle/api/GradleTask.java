// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.api;

/**
* Returns the name of the task.
*/
public interface GradleTask {
  String getName();

  String getGroup();

  String getPath();

  String getProject();

  String getBuildFile();

  String getRootProject();

  String getDescription();

  boolean getDebuggable();
}
