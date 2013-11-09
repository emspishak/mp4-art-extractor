package com.hotcats.mp4artextractor.printer;

import com.hotcats.mp4artextractor.data.atom.FtypAtom;
import com.hotcats.mp4artextractor.data.atom.MdatAtom;
import com.hotcats.mp4artextractor.data.atom.MoovAtom;
import com.hotcats.mp4artextractor.data.atom.SkipAtom;

public interface Visitor {

  public void visit(FtypAtom ftypAtom);
  public void visit(MdatAtom mdatAtom);
  public void visit(MoovAtom moovAtom);
  public void visit(SkipAtom skipAtom);
}
