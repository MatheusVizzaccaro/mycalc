package com.github.matheusvizzaccaro.mycalc.util;

import com.github.matheusvizzaccaro.mycalc.view.Session;

public class Calculation {
  private Integer id;
  private String calcCode;
  private String title;
  private String description;

  public Calculation(Integer id, String calcCode, String title, String description) {
    this.id = id;
    this.calcCode = calcCode;
    this.title = title;
    this.description = description;
  }

  public String getCalcCode() {
    return calcCode;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }
}
