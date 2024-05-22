// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package ch.epfl.scala.bsp4j.extended;

import java.util.Objects;

public class GradleEnvironment {
    private String gradleUserHome;
    private String gradleVersion;

    public GradleEnvironment() {
    }

    public GradleEnvironment(String gradleUserHome, String gradleVersion) {
        this.gradleUserHome = gradleUserHome;
        this.gradleVersion = gradleVersion;
    }

    public String getGradleUserHome() {
        return gradleUserHome;
    }

    public void setGradleUserHome(String gradleUserHome) {
        this.gradleUserHome = gradleUserHome;
    }

    public String getGradleVersion() {
        return gradleVersion;
    }

    public void setGradleVersion(String gradleVersion) {
        this.gradleVersion = gradleVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradleEnvironment that = (GradleEnvironment) o;
        return Objects.equals(gradleUserHome, that.gradleUserHome) && Objects.equals(gradleVersion, that.gradleVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradleUserHome, gradleVersion);
    }

    @Override
    public String toString() {
        return "GradleEnvironment{" +
                "gradleUserHome='" + gradleUserHome + '\'' +
                ", gradleVersion='" + gradleVersion + '\'' +
                '}';
    }
}
