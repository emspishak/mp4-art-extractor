package com.hotcats.mp4artextractor.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.hotcats.mp4artextractor.data.atom.Atom;

public class AtomList implements Iterable<Atom> {

  private final List<Atom> atoms;

  private AtomList(List<Atom> atoms) {
    this.atoms = Collections.unmodifiableList(atoms);
  }

  public Iterator<Atom> iterator() {
    return atoms.iterator();
  }

  public static class Builder {

    private final List<Atom> atoms;

    public Builder() {
      atoms = new ArrayList<>();
    }

    public Builder addAtom(Atom atom) {
      atoms.add(atom);
      return this;
    }

    public AtomList build() {
      return new AtomList(atoms);
    }
  }
}
