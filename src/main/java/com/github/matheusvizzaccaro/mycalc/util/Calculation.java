package com.github.matheusvizzaccaro.mycalc.util;

import com.github.matheusvizzaccaro.mycalc.view.Session;

public class Calculation {
  private Integer id;
  private String calcCode;

  public Calculation(Session session, String calcCode) {
    this.id = session.getId();
    this.calcCode=calcCode;
  }

  public String getCalcCode() {
    return calcCode;
  }
}
