package com.github.matheusvizzaccaro.mycalc.view;

import com.github.matheusvizzaccaro.mycalc.controller.LoginController;

import java.util.Scanner;

public class Login {
  private String getInputUsername() {
    System.out.println("Digite seu nome de usuário:\n");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private String getInputPassword() {
    System.out.println("Digite sua senha:\n");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  void login() {
    String username = getInputUsername();
    String password = getInputPassword();
    LoginController loginController = new LoginController();
    loginController.loginController(username, password);
  }
}
