package com.hotcats.mp4artextractor.data.atom;

import java.util.Collections;
import java.util.List;

import com.hotcats.mp4artextractor.printer.Visitor;

public class UdtaAtom extends Atom {

  private final List<UserData> userDatas;

  public UdtaAtom(int size, long extendedSize, List<UserData> userDatas) {
    super(AtomType.UDTA, size, extendedSize);
    this.userDatas = Collections.unmodifiableList(userDatas);
  }

  public List<UserData> getUserDatas() {
    return userDatas;
  }

  @Override
  public void accept(Visitor visitor, int indentationLevel) {
    visitor.visit(this, indentationLevel);
  }

  public static class UserData {

    private final int size;
    private final byte[] type;
    private final byte[] data;

    public UserData(int size, byte[] type, byte[] data) {
      this.size = size;
      this.type = type;
      this.data = data;
    }

    public int getSize() {
      return size;
    }

    public byte[] getType() {
      return type;
    }

    public byte[] getData() {
      return data;
    }
  }
}
