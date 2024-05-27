// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.services;

import ch.epfl.scala.bsp4j.extended.GetBuildResult;
import com.microsoft.java.bs.core.internal.handlers.GetBuildHandler;
import ch.epfl.scala.bsp4j.extended.GetBuildParams;

/**
 * The service to handle the task.
 */
public class TaskService {
  public GetBuildResult getBuildResult(GetBuildParams params) {
    return new GetBuildHandler(params).run();
  }
}
