package com.github.matheusvizzaccaro.mycalc.view;

import com.github.matheusvizzaccaro.mycalc.controller.SignUpController;

import java.util.Scanner;

public class SignUp {
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

  public Integer setUserInfo() {
    String username = getInputUsername();
    String password = getInputPassword();

    SignUpController signUpController = new SignUpController();
    return signUpController.setUserInfo(username, password);
  }
}
