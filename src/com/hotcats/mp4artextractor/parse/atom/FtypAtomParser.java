package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hotcats.mp4artextractor.data.atom.AtomType;
import com.hotcats.mp4artextractor.data.atom.FtypAtom;

public class FtypAtomParser extends AtomParser {

  private static final int MAJOR_BRAND_SIZE = 4;
  private static final int MINOR_VERSION_SIZE = 4;
  private static final int COMPATIBLE_BRAND_SIZE = 4;

  public FtypAtomParser(FileInputStream fileInput, int bytesRead, int size,
      long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public FtypAtom parse() throws IOException {
    byte[] majorBrand = readBytes(MAJOR_BRAND_SIZE);
    byte[] minorVersion = readBytes(MINOR_VERSION_SIZE);

    List<byte[]> compatibleBrands = new ArrayList<>();
    while (getBytesRead() < getSize()) {
      compatibleBrands.add(readBytes(COMPATIBLE_BRAND_SIZE));
    }

    return new FtypAtom(getSize(), getExtendedSize(), majorBrand, minorVersion,
        compatibleBrands);
  }

  public static class Factory implements AtomParserFactory {

    public FtypAtomParser getInstance(AtomType type, FileInputStream fileInput,
        int bytesRead, int size, long extendedSize) {
      return new FtypAtomParser(fileInput, bytesRead, size, extendedSize);
    }
  }
}
