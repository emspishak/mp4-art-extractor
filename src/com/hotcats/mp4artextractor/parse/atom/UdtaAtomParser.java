package com.hotcats.mp4artextractor.parse.atom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.data.atom.AtomType;
import com.hotcats.mp4artextractor.data.atom.UdtaAtom;

public class UdtaAtomParser extends AtomParser {

  public UdtaAtomParser(FileInputStream fileInput, int bytesRead, int size,
      long extendedSize) {
    super(fileInput, bytesRead, size, extendedSize);
  }

  @Override
  public Atom parse() throws IOException {
    List<UdtaAtom.UserData> userDatas = new ArrayList<>();
    while (this.getBytesRead() < this.getSize()) {
      if (this.getSize() - this.getBytesRead() == INT_SIZE) {
        // "For historical reasons, the data list is optionally terminated by a
        // 32-bit integer set to 0."
        readInt();
      } else {
        int size = readInt();
        byte[] type = readBytes(TYPE_SIZE);
        byte[] data = readBytes(size - INT_SIZE - TYPE_SIZE);
        userDatas.add(new UdtaAtom.UserData(size, type, data));
      }
    }
    return new UdtaAtom(this.getSize(), this.getExtendedSize(), userDatas);
  }

  public static class Factory implements AtomParserFactory {

    @Override
    public AtomParser getInstance(AtomType type, FileInputStream fileInput,
        int bytesRead, int size, long extendedSize) {
      return new UdtaAtomParser(fileInput, bytesRead, size, extendedSize);
    }
  }
}
