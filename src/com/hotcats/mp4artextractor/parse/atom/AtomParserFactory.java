package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;

public interface AtomParserFactory {

  public AtomParser getInstance(FileInputStream fileInput, int bytesRead,
      int size, long extendedSize);
}
