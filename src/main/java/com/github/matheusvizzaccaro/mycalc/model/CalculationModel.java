package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.database.Database;
import com.github.matheusvizzaccaro.mycalc.util.Calculation;

public class CalculationModel {
  public Boolean insertCalculation(Calculation calculation) {
    if(calculation == null) {
      return null;
    }

    Database database = new Database();
    database.insert("INSERT INTO calculations() VALUES ()")
  }
}
