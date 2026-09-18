package com.github.matheusvizzaccaro.mycalc.view;

import com.github.matheusvizzaccaro.mycalc.controller.CalculationController;
import com.github.matheusvizzaccaro.mycalc.util.Calculation;
import com.github.matheusvizzaccaro.mycalc.util.JsonManager;

import java.util.Scanner;

public class Calculator {
  private Session session;

  public Calculator(Session session) {
    this.session=session;
  }

  public void showCalc() {
    Scanner scanner=new Scanner(System.in);
    System.out.println("""
            Olá %s!
            Escolha qual operação você deseja realizar:
            1 - Criar Cálculo
            2 - Ler Cálculo
            """.formatted(session.getUsername()));
    int option=scanner.nextInt();
    createCalc(option);
  }

  public void createCalc(int option) {
    if(option==1) {
      System.out.println("Escreva o cálculo desejado separado apenas por espaço e os sinais.\n(Ex: 10 + 20)");
      Scanner scanner=new Scanner(System.in);
      String input=scanner.nextLine();
      JsonManager jsonMngr=new JsonManager();

      Calculation calculation = createCode(input);
      if(insertCalculation(calculation)) {
        System.out.println("Cálculo cadastrado com sucesso.");
      }
      System.out.println("Erro ao cadastrar cálculo.");

/*    Expression expression=new ExpressionBuilder(createCode(input).getCalcCode()).build();
      double result=expression.evaluate();
      System.out.println("resultado: "+result);*/
    } else {
      System.out.println("Operação não conhecida.");
    }
  }

  private Calculation createCode(String input) {
    String cCode="";
    String[] params=input.split(" ");

    for(int i=0;i<params.length;i++) {
      cCode+=params[i];
    }

    return new Calculation(session, cCode);
  }

  private Boolean insertCalculation(Calculation calculation) {
    CalculationController calculationController = new CalculationController();
    return calculationController.insertCalculation(calculation, session);
  }
}
