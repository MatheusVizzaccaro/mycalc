package com.github.matheusvizzaccaro.mycalc.view;

import com.github.matheusvizzaccaro.mycalc.controller.CalculationController;
import com.github.matheusvizzaccaro.mycalc.util.Calculation;
import com.github.matheusvizzaccaro.mycalc.util.JsonManager;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.List;
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
    calcMenu(option);
  }

  public void calcMenu(int option) {
    if(option==1) {
      createCalculation();
    }
    if(option==2) {
      showCalculations();
    }
    else {
      System.out.println("Operação não conhecida.");
    }
  }

  private void showCalculations() {
    CalculationController calculationController = new CalculationController();
    List<String> calculations = calculationController.getCalculations(session);

    for(int i=0;i<calculations.size();i++) {
      System.out.println(calculations.get(i));
    }
  }

  private void createCalculation() {
    System.out.println("Escreva o cálculo desejado separado apenas por espaço e os sinais.\n(Ex: 10 + 20)");
    Scanner scanner=new Scanner(System.in);
    String input=scanner.nextLine();
    JsonManager jsonMngr=new JsonManager();

    Calculation calculation = createCode(input);
    if(insertCalculation(calculation)) {
      System.out.println("Cálculo cadastrado com sucesso.");
    }
  }

  private void evaluateCalculation(String cCode) {
    Expression expression=new ExpressionBuilder(cCode).build();
    double result=expression.evaluate();
    System.out.println("resultado: "+result);
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
