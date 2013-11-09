package com.hotcats.mp4artextractor.data;


public class Mp4File {

  private final AtomList atoms;

  public Mp4File(AtomList atoms) {
    this.atoms = atoms;
  }

  public AtomList getAtoms() {
    return atoms;
  }
}
