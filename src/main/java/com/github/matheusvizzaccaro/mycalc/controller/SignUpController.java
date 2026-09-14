package com.github.matheusvizzaccaro.mycalc.controller;

import com.github.matheusvizzaccaro.mycalc.model.SignUpModel;

public class SignUpController {
  public boolean setUserInfo(String username, String password) {
    //todo: implementar/validar regras de negócio

    if(username == null || username.length() < 5 || username.length() > 20) {
      return false;
    }

    if(password == null || password.length() < 8 || password.length() > 20) {
      return false;
    }

    String treatedUsername = username.trim();
    String treatedPassword = password.trim();

    SignUpModel signUpModel = new SignUpModel();
    if(signUpModel.insertUser(treatedUsername, treatedPassword)) {
      return true;
    }
    return false;
  }
}
