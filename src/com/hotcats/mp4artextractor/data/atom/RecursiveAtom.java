package com.hotcats.mp4artextractor.data.atom;

import com.hotcats.mp4artextractor.data.AtomList;
import com.hotcats.mp4artextractor.printer.Visitor;

/**
 * An atom which is only made up of other atoms.
 */
public class RecursiveAtom extends Atom {

  private final AtomList atoms;

  public RecursiveAtom(AtomType type, int size, long extendedSize, AtomList atoms) {
    super(type, size, extendedSize);
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
