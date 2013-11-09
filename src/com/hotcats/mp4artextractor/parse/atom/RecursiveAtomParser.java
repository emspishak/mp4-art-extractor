package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.AtomList;
import com.hotcats.mp4artextractor.data.atom.AtomType;
import com.hotcats.mp4artextractor.data.atom.RecursiveAtom;
import com.hotcats.mp4artextractor.parse.AtomListParser;

public class RecursiveAtomParser extends AtomParser {

  private final AtomType type;

  public RecursiveAtomParser(AtomType type, FileInputStream fileInput,
      int bytesRead, int size, long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
    this.type = type;
  }

  @Override
  public RecursiveAtom parse() throws IOException {
    AtomListParser parser = new AtomListParser(this.getFileInput(),
        this.getBytesRead(), this.getSize());
    AtomList atoms = parser.parseAtomList();
    return new RecursiveAtom(type, this.getSize(), this.getExtendedSize(), atoms);
  }

  public static class Factory implements AtomParserFactory {

    public RecursiveAtomParser getInstance(AtomType type, FileInputStream fileInput, int bytesRead,
        int size, long extendedSize) {
      return new RecursiveAtomParser(type, fileInput, bytesRead, size, extendedSize);
    }
  }
}
