package com.hotcats.mp4artextractor.parse;

import java.io.FileInputStream;

import com.hotcats.mp4artextractor.data.atom.MoovAtom;

public class MoovAtomParser extends AtomParser {

  public MoovAtomParser(FileInputStream fileInput, int bytesRead, int size,
      long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public MoovAtom parse() {
    // TODO implement
    return null;
  }
}
