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

  public String bytesToString(byte[] bytes) {
    return new String(bytes);
  }

  @Override
  public String toString() {
    // TODO: print raw byes too
    // TODO: clean up this key/value type printing
    StringBuilder builder = new StringBuilder();
    builder.append("type: ").append(getType()).append('\n');
    builder.append("  size: ").append(getSize()).append('\n');
    return builder.toString();
  }
}
