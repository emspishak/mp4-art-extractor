package com.hotcats.mp4artextractor.data.atom;

import com.hotcats.mp4artextractor.printer.Visitor;

public class DataAtom extends Atom {

  private final int indicator;
  private final int dataType;
  private final byte[] country;
  private final byte[] language;
  private final byte[] data;

  public DataAtom(AtomType type, int size, long extendedSize, int indicator,
      int dataType, byte[] country, byte[] language, byte[] data) {
    super(type, size, extendedSize);
    this.indicator = indicator;
    this.dataType = dataType;
    this.country = country;
    this.language = language;
    this.data = data;
  }

  public int getIndicator() {
    return indicator;
  }

  public int getDataType() {
    return dataType;
  }

  public byte[] getCountry() {
    return country;
  }

  public byte[] getLanguage() {
    return language;
  }

  public byte[] getData() {
    return data;
  }

  @Override
  public void accept(Visitor visitor, int indentationLevel) {
    visitor.visit(this, indentationLevel);
  }
}
