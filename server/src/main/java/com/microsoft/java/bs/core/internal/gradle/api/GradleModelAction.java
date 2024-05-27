// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.gradle.api;

import org.gradle.tooling.BuildAction;
import org.gradle.tooling.BuildController;

/**
 * Represents a build action that returns a Gradle project model.
 
 */
public class GradleModelAction implements BuildAction<GradleProjectModel> {
  @Override
  public GradleProjectModel execute(BuildController controller) {
    return controller.getModel(GradleProjectModel.class);
  }
}
