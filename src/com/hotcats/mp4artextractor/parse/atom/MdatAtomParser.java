package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;

import com.hotcats.mp4artextractor.data.atom.MdatAtom;

public class MdatAtomParser extends AtomParser {

  public MdatAtomParser(FileInputStream fileInput, int bytesRead, int size, long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public MdatAtom parse() {
    return new MdatAtom(getSize(), getExtendedSize());
  }

  public static class Factory implements AtomParserFactory {

    public MdatAtomParser getInstance(FileInputStream fileInput, int bytesRead,
        int size, long extendedSize) {
      return new MdatAtomParser(fileInput, bytesRead, size, extendedSize);
    }
  }
}
