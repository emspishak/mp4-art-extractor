package com.hotcats.mp4artextractor.parse;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.AtomList;
import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.parse.atom.AtomParser;

public class AtomListParser {

  private final FileInputStream fileInput;
  private long bytesRead;
  private final long size;

  public AtomListParser(FileInputStream fileInput, long size) {
    this(fileInput, 0, size);
  }

  public AtomListParser(FileInputStream fileInput, long bytesRead, long size) {
    this.fileInput = fileInput;
    this.bytesRead = bytesRead;
    this.size = size;
  }

  public AtomList parseAtomList() throws IOException {
    AtomList.Builder builder = new AtomList.Builder();
    while (bytesRead < size) {
      AtomParser atomParser = AtomParser.getAtomParser(fileInput);
      Atom atom = atomParser.parse();
      bytesRead += atom.getSize();
      builder.addAtom(atom);
    }
    return builder.build();
  }
}
