package com.hotcats.mp4artextractor.parse;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.AtomList;
import com.hotcats.mp4artextractor.data.Mp4File;

public class Mp4FileParser {

  private final FileInputStream fileInput;
  private final long fileSize;

  public Mp4FileParser(FileInputStream fileInput, long fileSize) {
    this.fileInput = fileInput;
    this.fileSize = fileSize;
  }

  public Mp4File parse() {
    AtomListParser parser = new AtomListParser(fileInput, fileSize);
    AtomList atoms;
    try {
      atoms = parser.parseAtomList();
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      return null;
    }
    return new Mp4File(atoms);
  }
}
