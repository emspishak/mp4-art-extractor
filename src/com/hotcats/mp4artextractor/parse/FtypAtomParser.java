package com.hotcats.mp4artextractor.parse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hotcats.mp4artextractor.data.atom.FtypAtom;

public class FtypAtomParser extends AtomParser {

  private static final int MAJOR_BRAND_SIZE = 4;
  private static final int MINOR_VERSION_SIZE = 4;
  private static final int COMPATIBLE_BRAND_SIZE = 4;

  public FtypAtomParser(FileInputStream fileInput, int size) {
    super(fileInput, size);
  }

  @Override
  public FtypAtom parse() throws IOException {
    // For size and type.
    int bytesRead = 8;

    byte[] majorBrand = readBytes(MAJOR_BRAND_SIZE);
    bytesRead += MAJOR_BRAND_SIZE;

    byte[] minorVersion = readBytes(MINOR_VERSION_SIZE);
    bytesRead += MINOR_VERSION_SIZE;

    List<byte[]> compatibleBrands = new ArrayList<>();
    while (bytesRead < getSize()) {
      compatibleBrands.add(readBytes(COMPATIBLE_BRAND_SIZE));
      bytesRead += COMPATIBLE_BRAND_SIZE;
    }
    return new FtypAtom(getSize(), majorBrand, minorVersion, compatibleBrands);
  }
}
