package com.github.matheusvizzaccaro.mycalc.view;

import com.github.matheusvizzaccaro.mycalc.controller.LoginController;

public class Login {
  private final String username;
  private final String password;
  private Integer id;

  public Login(String username, String password) {
    this.username=username;
    this.password=password;
  }

  public boolean isValidLogin(Login login) {
    LoginController loginController = new LoginController();
    this.id = loginController.isValidLogin(login);
    if(this.id != null) {
      return true;
    }
    return false;
  }

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
