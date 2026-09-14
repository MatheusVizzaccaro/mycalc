package com.github.matheusvizzaccaro.mycalc;

import com.github.matheusvizzaccaro.mycalc.view.AuthMenu;
import com.github.matheusvizzaccaro.mycalc.view.Calculator;

public class Main {
  public static void main(String[] args) {
    AuthMenu authMenu= new AuthMenu();
    Calculator calculator = authMenu.choiceMenu();

    if(calculator != null) {
      calculator.showCalc();
    }
  }
}