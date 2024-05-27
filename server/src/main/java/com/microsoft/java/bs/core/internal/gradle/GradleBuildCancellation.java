package com.microsoft.java.bs.core.internal.gradle;

import com.microsoft.java.bs.core.internal.gradle.exceptions.GradleCancellationException;
import com.google.common.base.Strings;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.gradle.tooling.CancellationToken;
import org.gradle.tooling.CancellationTokenSource;
import org.gradle.tooling.GradleConnector;

/**
 * Provides methods to cancel Gradle builds.
 */
public class GradleBuildCancellation {
  private static final ConcurrentMap<String, CancellationTokenSource> tokens 
      = new ConcurrentHashMap<>();

  private GradleBuildCancellation() {
  }

  /**
   * Builds a cancellation token for a Gradle build.
   *
   * @param cancellationKey the key to associate with the cancellation token
   * @return the cancellation token
   */
  public static CancellationToken buildToken(String cancellationKey) {
    CancellationTokenSource cancellationTokenSource = GradleConnector.newCancellationTokenSource();
    tokens.put(cancellationKey, cancellationTokenSource);
    return cancellationTokenSource.token();
  }

  public static void clearToken(String cancellationKey) {
    tokens.remove(cancellationKey);
  }

  /**
   * Cancels a Gradle build.
   *
   * @param cancellationKey the key associated with the cancellation token
   */
  public static void cancelBuild(String cancellationKey) throws GradleCancellationException {
    if (Strings.isNullOrEmpty(cancellationKey)) {
      throw new GradleCancellationException("No cancellation key specified");
    }
    CancellationTokenSource cancellationTokenSource = tokens.get(cancellationKey);
    if (cancellationTokenSource == null) {
      throw new GradleCancellationException("Build is not running for key: " + cancellationKey);
    } else {
      cancellationTokenSource.cancel();
    }
  }

  /**
   * Cancels all Gradle builds.
   */
  public static void cancelBuilds() throws GradleCancellationException {
    for (String cancellationKey : tokens.keySet()) {
      cancelBuild(cancellationKey);
    }
  }
}
