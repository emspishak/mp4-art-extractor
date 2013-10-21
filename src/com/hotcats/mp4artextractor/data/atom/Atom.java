package com.hotcats.mp4artextractor.data.atom;


public class Atom {
  private final AtomType type;
  private final int size;
  private final long extendedSize;

  public Atom(AtomType type, int size, long extendedSize) {
    this.type = type;
    this.size = size;
    this.extendedSize = extendedSize;
  }

  public AtomType getType() {
    return type;
  }

  public int getSize() {
    return size;
  }

  public long getExtendedSize() {
    return extendedSize;
  }
}
