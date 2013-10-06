package com.hotcats.mp4artextractor.parse;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import com.hotcats.mp4artextractor.data.atom.Atom;

public abstract class AtomParser {
  public static final byte[] FTYP_BYTES = {'f', 't', 'y', 'p'};

  private final FileInputStream fileInput;
  private final int size;

  public AtomParser(FileInputStream fileInput, int size) {
    this.fileInput = fileInput;
    this.size = size;
  }

  public abstract Atom parse() throws IOException;

  public int getSize() {
    return size;
  }

  public static AtomParser getAtomParser(FileInputStream fileInput) throws IOException {
    int size = readInt(fileInput);

    byte[] type = readBytes(fileInput, 4);

    if (Arrays.equals(FTYP_BYTES, type)) {
      return new FtypAtomParser(fileInput, size);
    }
    throw new UnsupportedOperationException("Illegal type: "
        + Arrays.toString(type) + " (" + new String(type) + ")");
  }

  protected int readInt() throws IOException {
    return readInt(fileInput);
  }

  private static int readInt(FileInputStream fileInput) throws IOException {
    byte[] bytes = readBytes(fileInput, 4);
    return ByteBuffer.wrap(bytes).getInt();
  }

  protected byte[] readBytes(int num) throws IOException {
    return readBytes(fileInput, num);
  }

  private static byte[] readBytes(FileInputStream fileInput, int num) throws IOException {
    byte[] bytes = new byte[num];
    fileInput.read(bytes);
    return bytes;
  }
}
