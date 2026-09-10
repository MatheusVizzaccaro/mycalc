package com.github.matheusvizzaccaro.mycalc.view;

import com.github.matheusvizzaccaro.mycalc.controller.LoginController;

public class Login {
  private final String username;
  private final String password;

  public Login(String username, String password) {
    this.username=username;
    this.password=password;
  }

  public boolean isValidLogin() {
    LoginController loginController = new LoginController();
    return loginController.isValidLogin(this.username, this.password);
  }
}
