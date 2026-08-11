package com.github.matheusvizzaccaro.mycalc;

import java.util.Scanner;

public class Calculator {
    public void showCalc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a operação desejada: \n\n 01 - Soma \n 02 - Subtração");
        int option = scanner.nextInt();
        createCalc(option);
    }

    public void createCalc(int option) {
        if(option == 1) {
            System.out.println("Escreva o cálculo desejado separado apenas por espaço e os sinais.\n(Ex: 10 + 20)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String cCode = "";

            String[] params = input.split(" ");

            for (int i=0;i<params.length;i++) {
                cCode += params[i];
            }

            CalcCode calcCode = new CalcCode(cCode);
            JsonManager jsonMngr = new JsonManager();

            jsonMngr.exportJson(calcCode);
        } else {
            System.out.println("Operação não conhecida.");
        }
    }
}
