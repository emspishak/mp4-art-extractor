package com.hotcats.mp4artextractor.parse;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.Mp4File;

public class Mp4FileParser {

  private final FileInputStream fileInput;

  public Mp4FileParser(FileInputStream fileInput) {
    this.fileInput = fileInput;
  }

  public Mp4File parse() {
    Mp4File.Builder builder = new Mp4File.Builder();
    try {
      AtomParser atomParser = AtomParser.getAtomParser(fileInput);
      builder.addAtom(atomParser.parse());
      return builder.build();
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      return null;
    }
  }
}
