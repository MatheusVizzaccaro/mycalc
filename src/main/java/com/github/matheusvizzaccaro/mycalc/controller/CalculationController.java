package com.github.matheusvizzaccaro.mycalc.controller;

import com.github.matheusvizzaccaro.mycalc.model.CalculationModel;
import com.github.matheusvizzaccaro.mycalc.util.Calculation;
import com.github.matheusvizzaccaro.mycalc.view.Session;

public class CalculationController {
  public Boolean insertCalculation(Calculation calculation, Session session) {
    //todo: implementar regras de negócio
    if(calculation.getCalcCode() == null) {
      return false;
    }

    CalculationModel calculationModel = new CalculationModel();
    return calculationModel.insertCalculation(calculation, session);
  }
}
