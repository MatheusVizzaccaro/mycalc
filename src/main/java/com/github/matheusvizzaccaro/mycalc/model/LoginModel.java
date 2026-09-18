package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.database.Database;
import com.github.matheusvizzaccaro.mycalc.view.Login;

import java.util.List;

public class LoginModel {
  public Integer loginSelect(Login login) {
    Database db = new Database();
    List<String> serverCredentials = db.select("SELECT id, username, password FROM user WHERE username = ? AND password = ?", new String[]{login.getUsername(), login.getPassword()});
    return Integer.parseInt(serverCredentials.getFirst());
  }
}
