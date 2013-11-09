package com.hotcats.mp4artextractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.hotcats.mp4artextractor.data.Mp4File;
import com.hotcats.mp4artextractor.parse.Mp4FileParser;
import com.hotcats.mp4artextractor.printer.Mp4FilePrinter;

public class Mp4ArtExtractor {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("USAGE: Mp4AlbumArtExtractor filename");
      System.exit(1);
    }
    System.out.println("Extracting album art from: " + args[0]);

    File file = new File(args[0]);
    FileInputStream fileInput = null;
    try {
      fileInput = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      System.out.println("Error, file not found: " + args[0]);
      System.exit(1);
    }

    Mp4FileParser parser = new Mp4FileParser(fileInput, file.length());
    Mp4File mp4File = parser.parse();
    new Mp4FilePrinter(mp4File).print();
  }
}
