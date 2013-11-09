package com.hotcats.mp4artextractor.printer;

import com.hotcats.mp4artextractor.data.atom.Atom;
import com.hotcats.mp4artextractor.data.atom.FtypAtom;
import com.hotcats.mp4artextractor.data.atom.MdatAtom;
import com.hotcats.mp4artextractor.data.atom.MoovAtom;

public interface Visitor {

  public void visit(Atom atom);
  public void visit(FtypAtom ftypAtom);
  public void visit(MdatAtom mdatAtom);
  public void visit(MoovAtom moovAtom);
}
