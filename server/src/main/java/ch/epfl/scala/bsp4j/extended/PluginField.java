// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

/**
 * PluginField.
 
 */
public class PluginField {
  private String name;
  private boolean deprecated;

  public PluginField(String name, boolean deprecated) {
    this.name = name;
    this.deprecated = deprecated;
  }

  public String getName() {
    return name;
  }

  public boolean isDeprecated() {
    return deprecated;
  }
}
