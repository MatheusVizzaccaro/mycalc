package com.github.matheusvizzaccaro.mycalc.controller;

import com.github.matheusvizzaccaro.mycalc.model.LoginModel;
import com.github.matheusvizzaccaro.mycalc.view.Login;

public class LoginController {
  //todo: implementar regras de negócio

  //Regras de negócio para o controller de login
  //Maior que 3 caracteres de username e menor que 20
  //Maior que 8 caracteres de senha e menor que 30
  public Integer isValidLogin(Login login) {
    if(login.getUsername() == null || login.getUsername().length()>20 || login.getUsername().length() <= 3) {
      return null;
    }
    if(login.getPassword() == null || login.getPassword().length()>30 || login.getPassword().length() <= 4) {
      return null;
    }
    LoginModel loginModel = new LoginModel();
    return loginModel.loginSelect(login);
  }
}
