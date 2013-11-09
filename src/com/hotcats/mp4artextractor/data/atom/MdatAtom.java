package com.hotcats.mp4artextractor.data.atom;

import com.hotcats.mp4artextractor.printer.Visitor;

public class MdatAtom extends Atom {

  public MdatAtom(int size, long extendedSize) {
    super(AtomType.MDAT, size, extendedSize);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
