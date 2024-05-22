// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.
package ch.epfl.scala.bsp4j.extended;

import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

public class GradleConfig {
    private String gradleHome;
    private String userHome;
    private Boolean wrapperEnabled;
    private String version;

    @NonNull
    private String jvmArguments;

    @NonNull
    private String javaExtensionVersion;

    public GradleConfig() {}

    public GradleConfig(String gradleHome, String userHome, Boolean wrapperEnabled, String version, @NonNull String jvmArguments, @NonNull String javaExtensionVersion) {
      this.gradleHome = gradleHome;
      this.userHome = userHome;
      this.wrapperEnabled = wrapperEnabled;
      this.version = version;
      this.jvmArguments = jvmArguments;
      this.javaExtensionVersion = javaExtensionVersion;
    }

    // Getters and Setters
    public String getGradleHome() {
      return gradleHome;
    }

    public void setGradleHome(String gradleHome) {
      this.gradleHome = gradleHome;
    }

    public String getUserHome() {
      return userHome;
    }

    public void setUserHome(String userHome) {
      this.userHome = userHome;
    }

    public Boolean getWrapperEnabled() {
      return wrapperEnabled;
    }

    public void setWrapperEnabled(Boolean wrapperEnabled) {
      this.wrapperEnabled = wrapperEnabled;
    }

    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    @NonNull
    public String getJvmArguments() {
      return jvmArguments;
    }

    public void setJvmArguments(@NonNull String jvmArguments) {
      this.jvmArguments = jvmArguments;
    }

    @NonNull
    public String getJavaExtensionVersion() {
      return javaExtensionVersion;
    }

    public void setJavaExtensionVersion(@NonNull String javaExtensionVersion) {
      this.javaExtensionVersion = javaExtensionVersion;
    }
  }
