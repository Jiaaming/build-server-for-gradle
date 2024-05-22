// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.
package ch.epfl.scala.bsp4j.extended;

import java.util.List;
import java.util.Objects;

public class JavaEnvironment {
    private String javaHome;
    private List<String> jvmArgs;

    public JavaEnvironment() {
    }

    public JavaEnvironment(String javaHome, List<String> jvmArgs) {
        this.javaHome = javaHome;
        this.jvmArgs = jvmArgs;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    public List<String> getJvmArgs() {
        return jvmArgs;
    }

    public void setJvmArgs(List<String> jvmArgs) {
        this.jvmArgs = jvmArgs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaEnvironment that = (JavaEnvironment) o;
        return Objects.equals(javaHome, that.javaHome) && Objects.equals(jvmArgs, that.jvmArgs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(javaHome, jvmArgs);
    }

    @Override
    public String toString() {
        return "JavaEnvironment{" +
                "javaHome='" + javaHome + '\'' +
                ", jvmArgs=" + jvmArgs +
                '}';
    }
}
