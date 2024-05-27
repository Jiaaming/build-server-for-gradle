package ch.epfl.scala.bsp4j.extended;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import com.microsoft.java.bs.core.internal.gradle.api.GradleDependencyType;

/**
 * Represents a dependency item in the dependency tree.
 */
public class DependencyItem {
  private String name;
  private GradleDependencyType type;
  private List<DependencyItem> children;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GradleDependencyType getType() {
    return type;
  }

  public void setType(GradleDependencyType type) {
    this.type = type;
  }

  public List<DependencyItem> getChildren() {
    return children;
  }

  public void setChildren(List<DependencyItem> children) {
    this.children = children;
  }

  /**
   * Builder class for DependencyItem.
   */
  public static class Builder {
    private String name;
    private GradleDependencyType type;
    private List<DependencyItem> children = new ArrayList<>();

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setType(GradleDependencyType type) {
      this.type = type;
      return this;
    }

    public Builder addAllChildren(List<DependencyItem> children) {
      this.children.addAll(children);
      return this;
    }

    /**
     * Build the DependencyItem object.
     */
    public DependencyItem build() {
      DependencyItem item = new DependencyItem();
      item.setName(this.name);
      item.setType(this.type);
      item.setChildren(this.children);
      return item;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, children);
  }
}
