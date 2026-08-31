package com.github.matheusvizzaccaro.mycalc.view;

import java.util.Scanner;

public class Login {
  String getInputUsername() {
    System.out.println("Digite seu nome de usuário:\n");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  String getInputPassword() {
    System.out.println("Digite sua senha:\n");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
