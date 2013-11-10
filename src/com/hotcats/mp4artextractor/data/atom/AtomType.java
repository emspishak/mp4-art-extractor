package com.hotcats.mp4artextractor.data.atom;

import java.util.Arrays;

public class AtomType {

  public static final AtomType FTYP =
      new AtomType(new byte[] { 'f', 't', 'y', 'p' });
  public static final AtomType MDIA =
      new AtomType(new byte[] { 'm', 'd', 'i', 'a' });
  public static final AtomType META =
      new AtomType(new byte[] { 'm', 'e', 't', 'a' });
  public static final AtomType MOOV =
      new AtomType(new byte[] { 'm', 'o', 'o', 'v' });
  public static final AtomType TRAK =
      new AtomType(new byte[] {'t', 'r', 'a', 'k' });
  public static final AtomType UDTA =
      new AtomType(new byte[] {'u', 'd', 't', 'a' });

  public static final AtomType[] RECURSIVE_ATOMS = { MDIA, META, MOOV, TRAK, UDTA };

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
