// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

package com.microsoft.java.bs.core.internal.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * A factory for creating the streams for supported transmission methods.
 *
 * @author Gorkem Ercan
 *
 */

public class ServerNamedPipeStream {

  public ServerNamedPipeStream() {
  }

  interface StreamProvider {
    InputStream getInputStream() throws IOException;

    OutputStream getOutputStream() throws IOException;
  }

  /**
   * PipeStreamProvider.
   */
  protected final class PipeStreamProvider implements StreamProvider {

    private InputStream input;
    private OutputStream output;

    public PipeStreamProvider() {
      initializeNamedPipe();
    }

    @Override
    public InputStream getInputStream() throws IOException {
      return input;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
      return output;
    }

    private void initializeNamedPipe() {
      File pipeFile = new File("/tmp/example.sock");
 
      if (isWindows()) {
        try {
          pipeFile = new File("/tmp/example");
          AsynchronousFileChannel clientChannel = AsynchronousFileChannel.open(
              pipeFile.toPath(),
              StandardOpenOption.CREATE,
              StandardOpenOption.READ,
              StandardOpenOption.WRITE);
          input = new NamedPipeInputStream(clientChannel);
          output = new NamedPipeOutputStream(clientChannel);
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else {
        if (pipeFile.exists()) {
          pipeFile.delete();
        }
        UnixDomainSocketAddress socketAddress = UnixDomainSocketAddress.of(pipeFile.toPath());
        try {
          ServerSocketChannel serverChannel = ServerSocketChannel
              .open(StandardProtocolFamily.UNIX);
          serverChannel.bind(socketAddress);
          SocketChannel clientChannel = serverChannel.accept();
          input = new NamedPipeInputStream(clientChannel);
          output = new NamedPipeOutputStream(clientChannel);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  /**
   * NamedPipeInputStream.
   */
  public class NamedPipeInputStream extends InputStream {

    private ReadableByteChannel unixChannel;
    private AsynchronousFileChannel winChannel;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    private int readyBytes = 0;

    public NamedPipeInputStream(ReadableByteChannel channel) {
      this.unixChannel = channel;
    }

    public NamedPipeInputStream(AsynchronousFileChannel channel) {
      this.winChannel = channel;
    }

    @Override
    public int read() throws IOException {
      if (buffer.position() < readyBytes) {
        return buffer.get() & 0xFF;
      }
      try {
        buffer.clear();
        if (winChannel != null) {
          readyBytes = winChannel.read(buffer, 0).get();
        } else {
          readyBytes = unixChannel.read(buffer);
        }
        if (readyBytes == -1) {
          return -1; // EOF
        }
        buffer.flip();
        return buffer.get() & 0xFF;
      } catch (InterruptedException | ExecutionException e) {
        throw new IOException(e);
      }
    }
  }

  /**
   * NamedPipeOutputStream.
   */
  public class NamedPipeOutputStream extends OutputStream {

    private WritableByteChannel unixChannel;
    private AsynchronousFileChannel winChannel;
    private ByteBuffer buffer = ByteBuffer.allocate(1);

    public NamedPipeOutputStream(WritableByteChannel channel) {
      this.unixChannel = channel;
    }

    public NamedPipeOutputStream(AsynchronousFileChannel channel) {
      this.winChannel = channel;
    }

    @Override
    public void write(int b) throws IOException {
      buffer.clear();
      buffer.put((byte) b);
      buffer.position(0);
      if (winChannel != null) {
        Future<Integer> result = winChannel.write(buffer, 0);
        try {
          result.get();
        } catch (Exception e) {
          throw new IOException(e);
        }
      } else {
        unixChannel.write(buffer);
      }
    }

    @Override
    public void write(byte[] b) throws IOException {
      final int buffer_size = 1024;
      int blocks = b.length / buffer_size;
      int writeBytes = 0;
      for (int i = 0; i <= blocks; i++) {
        int offset = i * buffer_size;
        int length = Math.min(b.length - writeBytes, buffer_size);
        if (length <= 0) {
          break;
        }
        writeBytes += length;
        ByteBuffer buffer = ByteBuffer.wrap(b, offset, length);
        if (winChannel != null) {
          Future<Integer> result = winChannel.write(buffer, 0);
          try {
            result.get();
          } catch (Exception e) {
            throw new IOException(e);
          }
        } else {
          unixChannel.write(buffer);
        }
      }
    }
  }

  private StreamProvider provider;

  /**
   * getSelectedStream.
   */
  public StreamProvider getSelectedStream() {
    if (provider == null) {
      provider = createProvider();
    }
    return provider;
  }

  private StreamProvider createProvider() {

    return new PipeStreamProvider();
  }

  public InputStream getInputStream() throws IOException {
    return getSelectedStream().getInputStream();
  }

  public OutputStream getOutputStream() throws IOException {
    return getSelectedStream().getOutputStream();
  }

  private static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase().contains("win");
  }
}
