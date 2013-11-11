package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;

import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.data.atom.AtomType;
import com.hotcats.mp4artextractor.data.atom.DataAtom;

public class DataAtomParser extends AtomParser {

  private static final int INDICATOR_SIZE = 1;
  private static final int DATA_TYPE_SIZE = 3;
  private static final int COUNTRY_SIZE = 2;
  private static final int LANGUAGE_SIZE = 2;

  public DataAtomParser(FileInputStream fileInput, int bytesRead, int size,
      long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public Atom parse() throws IOException {
    int indicator = readBytes(INDICATOR_SIZE)[0];
    int dataType = readNumber(DATA_TYPE_SIZE);
    byte[] country = readBytes(COUNTRY_SIZE);
    byte[] language = readBytes(LANGUAGE_SIZE);
    byte[] data = readBytes(getSize() - getBytesRead());
    return new DataAtom(AtomType.DATA, getSize(), getExtendedSize(), indicator,
        dataType, country, language, data);
  }

  public static class Factory implements AtomParserFactory {

    @Override
    public AtomParser getInstance(AtomType type, FileInputStream fileInput,
        int bytesRead, int size, long extendedSize) {
      return new DataAtomParser(fileInput, bytesRead, size, extendedSize);
    }
  }
}
