package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.data.atom.AtomType;
import com.hotcats.mp4artextractor.data.atom.SkipAtom;


public class FreeAtomParser extends AtomParser {

  public FreeAtomParser(FileInputStream fileInput, int bytesRead, int size, long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public Atom parse() throws IOException {
    skipRest();
    return new SkipAtom(AtomType.FREE, getSize(), getExtendedSize());
  }

  public static class Factory implements AtomParserFactory {

    public FreeAtomParser getInstance(FileInputStream fileInput, int bytesRead,
        int size, long extendedSize) {
      return new FreeAtomParser(fileInput, bytesRead, size, extendedSize);
    }
  }
}
