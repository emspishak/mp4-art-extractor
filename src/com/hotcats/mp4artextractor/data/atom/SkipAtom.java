package com.hotcats.mp4artextractor.data.atom;

import com.hotcats.mp4artextractor.printer.Visitor;

public class SkipAtom extends Atom {

  public SkipAtom(AtomType type, int size, long extendedSize) {
    super(type, size, extendedSize);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
