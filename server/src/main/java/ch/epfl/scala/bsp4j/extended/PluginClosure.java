package ch.epfl.scala.bsp4j.extended;

import java.util.List;

/**
 * PluginClosure.

 */
public class PluginClosure {
  private String name;
  private List<PluginMethod> methods;
  private List<PluginField> fields;

  /**
   * Constructor for PluginClosure.
   */
  public PluginClosure(String name, List<PluginMethod> methods, List<PluginField> fields) {
    this.name = name;
    this.methods = methods;
    this.fields = fields;
  }

  public String getName() {
    return name;
  }

  public List<PluginMethod> getMethods() {
    return methods;
  }

  public List<PluginField> getFields() {
    return fields;
  }
}
