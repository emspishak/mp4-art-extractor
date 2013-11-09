package com.hotcats.mp4artextractor.data.atom;

import java.util.Arrays;

public class AtomType {

  public static final AtomType FREE =
      new AtomType(new byte[] { 'f', 'r', 'e', 'e' });
  public static final AtomType FTYP =
      new AtomType(new byte[] { 'f', 't', 'y', 'p' });
  public static final AtomType MDAT =
      new AtomType(new byte[] { 'm', 'd', 'a', 't' });
  public static final AtomType MOOV =
      new AtomType(new byte[] { 'm', 'o', 'o', 'v' });

  private final byte[] bytes;

  public AtomType(byte[] bytes) {
    this.bytes = bytes;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof AtomType) {
      AtomType other = (AtomType) o;
      return Arrays.equals(this.bytes, other.bytes);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(bytes);
  }

  @Override
  public String toString() {
    return new String(bytes) + " - " + Arrays.toString(bytes);
  }
}
