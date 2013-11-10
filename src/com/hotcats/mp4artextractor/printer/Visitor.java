package com.hotcats.mp4artextractor.printer;

import com.hotcats.mp4artextractor.data.atom.FtypAtom;
import com.hotcats.mp4artextractor.data.atom.MdatAtom;
import com.hotcats.mp4artextractor.data.atom.RecursiveAtom;
import com.hotcats.mp4artextractor.data.atom.SkipAtom;
import com.hotcats.mp4artextractor.data.atom.UdtaAtom;

public interface Visitor {

  public void visit(FtypAtom ftypAtom, int indentationLevel);
  public void visit(MdatAtom mdatAtom, int indentationLevel);
  public void visit(RecursiveAtom recursiveAtom, int indentationLevel);
  public void visit(SkipAtom skipAtom, int indentationLevel);
  public void visit(UdtaAtom udtaAtom, int indentationLevel);
}
