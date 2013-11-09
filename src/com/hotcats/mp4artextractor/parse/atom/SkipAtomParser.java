package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.data.atom.AtomType;
import com.hotcats.mp4artextractor.data.atom.SkipAtom;

public class SkipAtomParser extends AtomParser {

  private final AtomType type;

  public SkipAtomParser(FileInputStream fileInput, int bytesRead, int size,
      long extendedSize, AtomType type) {
    super(fileInput, bytesRead, size, extendedSize);
    this.type = type;
  }

  @Override
  public Atom parse() throws IOException {
    skipRest();
    return new SkipAtom(type, this.getSize(), this.getExtendedSize());
  }
}
