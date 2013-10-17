package com.hotcats.mp4artextractor.data.atom;

public class MoovAtom extends Atom {

  public MoovAtom(int size, long extendedSize) {
    super(AtomType.MOOV, size, extendedSize);
  }
}
