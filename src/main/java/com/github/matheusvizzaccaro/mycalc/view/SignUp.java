package com.github.matheusvizzaccaro.mycalc.view;

import com.github.matheusvizzaccaro.mycalc.controller.SignUpController;

import java.util.Scanner;

public class SignUp {
  private final String username;
  private final String password;

  public SignUp(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Integer setUserInfo() {
    SignUpController signUpController = new SignUpController();
    return signUpController.setUserInfo(this.username, this.password);
  }
}
