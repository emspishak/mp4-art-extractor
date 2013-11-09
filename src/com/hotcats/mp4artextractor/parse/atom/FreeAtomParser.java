package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.data.atom.AtomType;


public class FreeAtomParser extends AtomParser {

  public FreeAtomParser(FileInputStream fileInput, int bytesRead, int size, long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public Atom parse() throws IOException {
    skipRest();
    return new Atom(AtomType.FREE, getSize(), getExtendedSize());
  }
}
