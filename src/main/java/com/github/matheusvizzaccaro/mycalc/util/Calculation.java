package com.github.matheusvizzaccaro.mycalc.util;

import com.github.matheusvizzaccaro.mycalc.controller.CalculationController;

public class Calculation {
  private String calcCode;

  public Calculation(String calcCode) {
    this.calcCode=calcCode;
  }

  public String getCalcCode() {
    return calcCode;
  }
}
