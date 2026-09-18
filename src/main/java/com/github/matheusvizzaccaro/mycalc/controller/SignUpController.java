package com.github.matheusvizzaccaro.mycalc.controller;

import com.github.matheusvizzaccaro.mycalc.model.SignUpModel;
import com.github.matheusvizzaccaro.mycalc.view.SignUp;

public class SignUpController {
  public boolean setUserInfo(SignUp signup) {
    //todo: implementar/validar regras de negócio

    if(signup.getUsername() == null || signup.getUsername().length() < 5 || signup.getUsername().length() > 20) {
      return false;
    }

    if(signup.getPassword() == null || signup.getPassword().length() < 8 || signup.getPassword().length() > 20) {
      return false;
    }

    String treatedUsername = signup.getUsername().trim();
    String treatedPassword = signup.getPassword().trim();

    SignUpModel signUpModel = new SignUpModel();
    if(signUpModel.insertUser(treatedUsername, treatedPassword)) {
      return true;
    }
    return false;
  }
}
