package com.github.matheusvizzaccaro.mycalc;

import com.github.matheusvizzaccaro.mycalc.view.Calculator;
import com.github.matheusvizzaccaro.mycalc.view.Session;

public class Main {
  public static void main(String[] args) {
//    Calculator calc=new Calculator();
//    calc.createCalc(1);
    Session session = new Session();
    session.startSession();
  }
}