package com.hotcats.mp4artextractor.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hotcats.mp4artextractor.data.atom.Atom;

public class Mp4File {

  private final List<Atom> atoms;

  private Mp4File(List<Atom> atoms) {
    this.atoms = Collections.unmodifiableList(atoms);
  }

  public List<Atom> getAtoms() {
    return atoms;
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

    public Mp4File build() {
      return new Mp4File(atoms);
    }
  }
}
