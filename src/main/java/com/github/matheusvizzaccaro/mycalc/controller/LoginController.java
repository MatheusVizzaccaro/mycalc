package com.github.matheusvizzaccaro.mycalc.controller;

import com.github.matheusvizzaccaro.mycalc.model.LoginModel;

public class LoginController {
  //Regras de negócio para o controller de login
  //Maior que 3 caracteres de username e menor que 20
  //Maior que 8 caracteres de senha e menor que 30
  public Integer getUserIdController(String username, String password) {
    if(username == null || username.length()>20 || username.length() <= 3) {
      return null;
    }
    if(password == null || password.length()>30 || password.length() <= 4) {
      return null;
    }
    LoginModel loginModel = new LoginModel();
    return loginModel.loginSelect(username, password);
  }
}
