package com.microsoft.java.bs.core.internal.gradle;

import java.io.ByteArrayOutputStream;

/**
 * ByteArrayOutputStream that flushes the buffer to a byte array on {@link #flush()}.
 */
public abstract class ByteBufferOutputStream extends ByteArrayOutputStream {
  @Override
  public void flush() {
    onFlush(toByteArray());
    reset();
  }

  public abstract void onFlush(byte[] bytes);
}
