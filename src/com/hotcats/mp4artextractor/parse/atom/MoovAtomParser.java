package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.AtomList;
import com.hotcats.mp4artextractor.data.atom.MoovAtom;
import com.hotcats.mp4artextractor.parse.AtomListParser;

public class MoovAtomParser extends AtomParser {

  public MoovAtomParser(FileInputStream fileInput, int bytesRead, int size,
      long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public MoovAtom parse() throws IOException {
    AtomListParser parser = new AtomListParser(this.getFileInput(),
        this.getBytesRead(), this.getSize());
    AtomList atoms = parser.parseAtomList();
    return new MoovAtom(this.getSize(), this.getExtendedSize(), atoms);
  }

  public static class Factory implements AtomParserFactory {

    public MoovAtomParser getInstance(FileInputStream fileInput, int bytesRead,
        int size, long extendedSize) {
      return new MoovAtomParser(fileInput, bytesRead, size, extendedSize);
    }
  }
}
