package com.hotcats.mp4artextractor.data.atom;

import com.hotcats.mp4artextractor.data.AtomList;
import com.hotcats.mp4artextractor.printer.Visitor;

public class MoovAtom extends Atom {

  private final AtomList atoms;

  public MoovAtom(int size, long extendedSize, AtomList atoms) {
    super(AtomType.MOOV, size, extendedSize);
    this.atoms = atoms;
  }

  public AtomList getAtoms() {
    return atoms;
  }

  @Override
  public void accept(Visitor visitor, int indentationLevel) {
    visitor.visit(this, indentationLevel);
  }
}
