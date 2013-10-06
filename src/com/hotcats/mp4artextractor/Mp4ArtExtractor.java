package com.hotcats.mp4artextractor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.hotcats.mp4artextractor.data.Mp4File;
import com.hotcats.mp4artextractor.parse.Mp4FileParser;

public class Mp4ArtExtractor {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("USAGE: Mp4AlbumArtExtractor filename");
      System.exit(1);
    }
    System.out.println("Extracting album art from: " + args[0]);

    FileInputStream fileInput = null;
    try {
      fileInput = new FileInputStream(args[0]);
    } catch (FileNotFoundException e) {
      System.out.println("Error, file not found: " + args[0]);
      System.exit(1);
    }

    Mp4FileParser parser = new Mp4FileParser(fileInput);
    Mp4File file = parser.parse();
    System.out.println(file);
  }
}
