// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

import java.util.Objects;

public class Environment {
    private GradleEnvironment gradleEnvironment;
    private JavaEnvironment javaEnvironment;

    public Environment() {
    }

    public Environment(GradleEnvironment gradleEnvironment, JavaEnvironment javaEnvironment) {
        this.gradleEnvironment = gradleEnvironment;
        this.javaEnvironment = javaEnvironment;
    }

    public GradleEnvironment getGradleEnvironment() {
        return gradleEnvironment;
    }

    public void setGradleEnvironment(GradleEnvironment gradleEnvironment) {
        this.gradleEnvironment = gradleEnvironment;
    }

    public JavaEnvironment getJavaEnvironment() {
        return javaEnvironment;
    }

    public void setJavaEnvironment(JavaEnvironment javaEnvironment) {
        this.javaEnvironment = javaEnvironment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Environment that = (Environment) o;
        return Objects.equals(gradleEnvironment, that.gradleEnvironment) && Objects.equals(javaEnvironment, that.javaEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradleEnvironment, javaEnvironment);
    }

    @Override
    public String toString() {
        return "Environment{" +
                "gradleEnvironment=" + gradleEnvironment +
                ", javaEnvironment=" + javaEnvironment +
                '}';
    }
}
