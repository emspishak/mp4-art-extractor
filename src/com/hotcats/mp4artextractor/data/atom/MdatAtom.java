package com.hotcats.mp4artextractor.data.atom;

public class MdatAtom extends Atom {

  public MdatAtom(int size, long extendedSize) {
    super(AtomType.MDAT, size, extendedSize);
  }
}
