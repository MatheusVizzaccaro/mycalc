package com.github.matheusvizzaccaro.mycalc.controller;

public class LoginController {
  public void loginController(String username, String password) {
    if(username == null || username.length()>20 || username.length() <= 3) {
      System.out.println("Não passaria para a model");
      return;
    }
    if(password == null || password.length()>20 || password.length() <= 3) {
      System.out.println("Não passaria para a model");
      return;
    }
    System.out.println("Passaria para a model.");
  }
}
