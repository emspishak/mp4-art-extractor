package com.hotcats.mp4artextractor.data.atom;


public abstract class Atom {
  private final AtomType type;
  private final int size;

  public Atom(AtomType type, int size) {
    this.type = type;
    this.size = size;
  }

  public AtomType getType() {
    return type;
  }

  public int getSize() {
    return size;
  }
}
