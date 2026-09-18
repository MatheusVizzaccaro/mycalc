package com.github.matheusvizzaccaro.mycalc.view;

import com.github.matheusvizzaccaro.mycalc.controller.SignUpController;

public class SignUp {
  private final String username;
  private final String password;

  public SignUp(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Boolean setUserInfo(SignUp signUp) {
    SignUpController signUpController = new SignUpController();
    return signUpController.setUserInfo(signUp);
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
