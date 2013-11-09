package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.hotcats.mp4artextractor.data.atom.Atom;

public abstract class AtomParser {

  public static final int INT_SIZE = 4;
  public static final int LONG_SIZE = 8;
  public static final int TYPE_SIZE = 4;
  public static final byte[] FREE_BYTES = { 'f', 'r', 'e', 'e' };
  public static final byte[] FTYP_BYTES = { 'f', 't', 'y', 'p' };
  public static final byte[] MDAT_BYTES = { 'm', 'd', 'a', 't' };
  public static final byte[] MOOV_BYTES = { 'm', 'o', 'o', 'v' };

  public static final Map<RawAtomType, AtomParserFactory> parsers;
  static {
    Map<RawAtomType, AtomParserFactory> parsersTemp = new HashMap<>();

    parsersTemp.put(new RawAtomType(FREE_BYTES), new FreeAtomParser.Factory());
    parsersTemp.put(new RawAtomType(FTYP_BYTES), new FtypAtomParser.Factory());
    parsersTemp.put(new RawAtomType(MDAT_BYTES), new MdatAtomParser.Factory());
    parsersTemp.put(new RawAtomType(MOOV_BYTES), new MoovAtomParser.Factory());

    parsers = Collections.unmodifiableMap(parsersTemp);
  }

  private final FileInputStream fileInput;
  private int bytesRead;
  private final int size;
  private final long extendedSize;

  public AtomParser(FileInputStream fileInput, int bytesRead, int size,
      long extendedSize) {
    this.fileInput = fileInput;
    this.bytesRead = bytesRead;
    this.size = size;
    this.extendedSize = extendedSize;
  }

  public abstract Atom parse() throws IOException;

  protected int getBytesRead() {
    return bytesRead;
  }

  protected void skipRest() throws IOException {
    long toSkip = getSize() - getBytesRead();
    long skipped = fileInput.skip(toSkip);
    if (toSkip != skipped) {
      throw new IOException("expected to skip " + toSkip
          + " bytes but actually skipped " + skipped + " bytes.");
    }
  }

  public int getSize() {
    return size;
  }

  public long getExtendedSize() {
    return extendedSize;
  }

  public static AtomParser getAtomParser(FileInputStream fileInput)
      throws IOException {
    int bytesRead = 0;

    int size = readInt(fileInput);
    bytesRead += INT_SIZE;

    if (size == 0) {
      // last atom of file
    }

    RawAtomType type = new RawAtomType(readBytes(fileInput, TYPE_SIZE));
    bytesRead += TYPE_SIZE;

    long extendedSize = 0;
    if (size == 1) {
      extendedSize = readLong(fileInput);
      bytesRead += LONG_SIZE;
    }

    if (parsers.containsKey(type)) {
      return parsers.get(type).getInstance(fileInput, bytesRead, size,
          extendedSize);
    }

    throw new UnsupportedOperationException("Illegal type: " + type);
  }

  protected FileInputStream getFileInput() {
    return fileInput;
  }

  protected int readInt() throws IOException {
    return readInt(fileInput);
  }

  private static int readInt(FileInputStream fileInput) throws IOException {
    byte[] bytes = readBytes(fileInput, INT_SIZE);
    return ByteBuffer.wrap(bytes).getInt();
  }

  protected long readLong() throws IOException {
    return readLong(fileInput);
  }

  private static long readLong(FileInputStream fileInput) throws IOException {
    byte[] bytes = readBytes(fileInput, LONG_SIZE);
    return ByteBuffer.wrap(bytes).getLong();
  }

  protected byte[] readBytes(int num) throws IOException {
    bytesRead += num;
    return readBytes(fileInput, num);
  }

  private static byte[] readBytes(FileInputStream fileInput, int num)
      throws IOException {
    byte[] bytes = new byte[num];
    fileInput.read(bytes);
    return bytes;
  }
}
