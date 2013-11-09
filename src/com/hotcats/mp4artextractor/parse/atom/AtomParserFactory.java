package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;

import com.hotcats.mp4artextractor.data.atom.AtomType;

public interface AtomParserFactory {

  public AtomParser getInstance(AtomType type, FileInputStream fileInput,
      int bytesRead, int size, long extendedSize);
}
