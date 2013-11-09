package com.hotcats.mp4artextractor.printer;

import java.util.Arrays;
import java.util.List;

import com.hotcats.mp4artextractor.data.Mp4File;
import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.data.atom.FtypAtom;
import com.hotcats.mp4artextractor.data.atom.MdatAtom;
import com.hotcats.mp4artextractor.data.atom.MoovAtom;

public class Mp4FilePrinter {

  private final Mp4File mp4File;

  public Mp4FilePrinter(Mp4File mp4file) {
    this.mp4File = mp4file;
  }

  public void print() {
    for (Atom a : mp4File.getAtoms()) {
      print(a);
    }
  }

  private void print(Atom atom) {
    System.out.println("type: " + atom.getType());
    System.out.println("  size: " + atom.getSize());
    System.out.println("  extendedSize: " + atom.getExtendedSize());
    switch (atom.getType()) {
    case FREE:
      // Do nothing, all fields have already been printed.
      break;
    case FTYP:
      printFtypAtom((FtypAtom) atom);
      break;
    case MDAT:
      printMdatAtom((MdatAtom) atom);
      break;
    case MOOV:
      printMoovAtom((MoovAtom) atom);
      break;
    }
  }

  private void printFtypAtom(FtypAtom ftypAtom) {
    printKeyValue("major brand", ftypAtom.getMajorBrand());
    printKeyValue("minor version", ftypAtom.getMinorVersion());
    printKeyValueList("compatible brands", ftypAtom.getCompatibleBrands());
  }

  private void printMdatAtom(MdatAtom mdatAtom) {

  }

  private void printMoovAtom(MoovAtom moovAtom) {
    // TODO implement
  }

  private void printKeyValue(String key, byte[] value) {
    System.out.println("  " + key + ": " + Arrays.toString(value)
        + " (" + bytesToString(value) + ")");
  }

  private void printKeyValueList(String key, List<byte[]> values) {
    System.out.println("  " + key + ":");
    for (byte[] value : values) {
      System.out.println("    " + Arrays.toString(value)
          + " (" + bytesToString(value) + ")");
    }
  }

  private String bytesToString(byte[] bytes) {
    return new String(bytes);
  }
}
