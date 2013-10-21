package com.hotcats.mp4artextractor.parse;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.Mp4File;
import com.hotcats.mp4artextractor.data.atom.Atom;

public class Mp4FileParser {

  private final FileInputStream fileInput;
  private final long fileSize;

  public Mp4FileParser(FileInputStream fileInput, long fileSize) {
    this.fileInput = fileInput;
    this.fileSize = fileSize;
  }

  public Mp4File parse() {
    Mp4File.Builder builder = new Mp4File.Builder();
    long bytesRead = 0;
    try {
      while (bytesRead < fileSize) {
        AtomParser atomParser = AtomParser.getAtomParser(fileInput);
        Atom atom = atomParser.parse();
        bytesRead += atom.getSize();
        builder.addAtom(atom);
      }
      return builder.build();
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      return null;
    }
  }
}
