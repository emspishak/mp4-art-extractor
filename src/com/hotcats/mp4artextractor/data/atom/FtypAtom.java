package com.hotcats.mp4artextractor.data.atom;

import java.util.List;

public class FtypAtom extends Atom {

  private final byte[] majorBrand;
  private final byte[] minorVersion;
  private final List<byte[]> compatibleBrands;

  public FtypAtom(int size, byte[] majorBrand, byte[] minorVersion, List<byte[]> compatibleBrands) {
    super(AtomType.FTYP, size);
    this.majorBrand = majorBrand;
    this.minorVersion = minorVersion;
    this.compatibleBrands = compatibleBrands;
  }

  public byte[] getMajorBrand() {
    return majorBrand;
  }

  public byte[] getMinorVersion() {
    return minorVersion;
  }

  public List<byte[]> getCompatibleBrands() {
    return compatibleBrands;
  }
}
