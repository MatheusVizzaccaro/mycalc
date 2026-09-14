package com.github.matheusvizzaccaro.mycalc.controller;

import com.github.matheusvizzaccaro.mycalc.model.CalculationModel;
import com.github.matheusvizzaccaro.mycalc.util.Calculation;

public class CalculationController {
  public Boolean insertCalculation(Calculation calculation) {
    if(calculation.getCalcCode() == null) {
      return false;
    }

    CalculationModel calculationModel = new CalculationModel();
    return calculationModel.insertCalculation(calculation);
  }
}
