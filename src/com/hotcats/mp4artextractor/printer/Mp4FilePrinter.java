package com.hotcats.mp4artextractor.printer;

import java.util.Arrays;
import java.util.List;

import com.hotcats.mp4artextractor.data.AtomList;
import com.hotcats.mp4artextractor.data.Mp4File;
import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.data.atom.FtypAtom;
import com.hotcats.mp4artextractor.data.atom.RecursiveAtom;
import com.hotcats.mp4artextractor.data.atom.SkipAtom;

public class Mp4FilePrinter implements Visitor {

  private static final String INDENTATION = "    ";

  private final Mp4File mp4File;

  public Mp4FilePrinter(Mp4File mp4file) {
    this.mp4File = mp4file;
  }

  public void print() {
    printAtomList(mp4File.getAtoms(), 0);
  }

  private void printAtomList(AtomList atoms, int indentationLevel) {
    for (Atom a : atoms) {
      print(a, indentationLevel);
    }
  }

  private void print(Atom atom, int indentationLevel) {
    println("type: " + atom.getType(), indentationLevel);
    println("  size: " + atom.getSize(), indentationLevel);
    println("  extendedSize: " + atom.getExtendedSize(), indentationLevel);

    atom.accept(this, indentationLevel);
  }

  @Override
  public void visit(FtypAtom ftypAtom, int indentationLevel) {
    printKeyValue("major brand", ftypAtom.getMajorBrand(), indentationLevel);
    printKeyValue("minor version", ftypAtom.getMinorVersion(), indentationLevel);
    printKeyValueList("compatible brands", ftypAtom.getCompatibleBrands(),
        indentationLevel);
  }

  @Override
  public void visit(RecursiveAtom recursiveAtom, int indentationLevel) {
    printAtomList(recursiveAtom.getAtoms(), indentationLevel + 1);
  }

  @Override
  public void visit(SkipAtom skipAtom, int indentationLevel) {
    println("  skipped", indentationLevel);
  }

  private void printKeyValue(String key, String value, int indentationLevel) {
    println("  " + key + ": " + value, indentationLevel);
  }

  private void printKeyValue(String key, byte[] value, int indentationLevel) {
    printKeyValue(key, Arrays.toString(value) + " (" + bytesToString(value)
        + ")", indentationLevel);
  }

  private void printKeyValueList(String key, List<byte[]> values,
      int indentationLevel) {
    println("  " + key + ":", indentationLevel);
    for (byte[] value : values) {
      println("    " + Arrays.toString(value) + " (" + bytesToString(value)
          + ")", indentationLevel);
    }
  }

  private String bytesToString(byte[] bytes) {
    return new String(bytes);
  }

  private void println(String s, int indentationLevel) {
    for (int i = 0; i < indentationLevel; i++) {
      System.out.print(INDENTATION);
    }
    System.out.println(s);
  }
}
