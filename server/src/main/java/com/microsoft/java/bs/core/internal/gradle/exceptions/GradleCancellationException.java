package com.microsoft.java.bs.core.internal.gradle.exceptions;

/**
 * Represents a cancellation exception in Gradle.
 */
public class GradleCancellationException extends Exception {
  private static final long serialVersionUID = 1L;

  public GradleCancellationException(String message) {
    super(message);
  }

  public GradleCancellationException(String message, Throwable cause) {
    super(message, cause);
  }
}
