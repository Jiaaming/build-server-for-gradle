// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

import java.util.List;

/**
 * PluginMethod.
 */
public class PluginMethod {
  private String name;
  private List<String> parameterTypes;
  private boolean deprecated;

  /**
   * Constructor for PluginMethod.
   */
  public PluginMethod(String name, List<String> parameterTypes, boolean deprecated) {
    this.name = name;
    this.parameterTypes = parameterTypes;
    this.deprecated = deprecated;
  }

  public String getName() {
    return name;
  }

  public List<String> getParameterTypes() {
    return parameterTypes;
  }

  public boolean isDeprecated() {
    return deprecated;
  }
}
