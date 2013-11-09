package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.atom.MoovAtom;

public class MoovAtomParser extends AtomParser {

  public MoovAtomParser(FileInputStream fileInput, int bytesRead, int size,
      long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public MoovAtom parse() throws IOException {
    skipRest();
    return new MoovAtom(this.getSize(), this.getExtendedSize());
  }
}
