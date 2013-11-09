package com.hotcats.mp4artextractor.data.atom;

import com.hotcats.mp4artextractor.printer.Visitor;

public interface Visitable {

  public void accept(Visitor visitor);
}
