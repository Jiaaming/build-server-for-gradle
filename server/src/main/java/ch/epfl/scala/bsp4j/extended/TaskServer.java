package ch.epfl.scala.bsp4j.extended;

import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import java.util.concurrent.CompletableFuture;

/**
 * TaskServer.
 */
public interface TaskServer {
  @JsonRequest("task/getBuild")
  CompletableFuture<GetBuildResult> getBuild(GetBuildParams params);

  // @JsonRequest("task/runBuild")
  // CompletableFuture<RunBuildResult> runBuild(RunBuildParams params);
}
