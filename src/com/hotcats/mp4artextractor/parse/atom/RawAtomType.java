package com.hotcats.mp4artextractor.parse.atom;

import java.util.Arrays;

public class RawAtomType {

  private final byte[] bytes;

  public RawAtomType(byte[] bytes) {
    this.bytes = bytes;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof RawAtomType) {
      RawAtomType other = (RawAtomType) o;
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
    return Arrays.toString(bytes) + " (" + new String(bytes) + ")";
  }
}
