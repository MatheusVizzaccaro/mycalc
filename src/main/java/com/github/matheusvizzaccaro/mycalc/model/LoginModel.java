package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.database.Database;
import java.util.List;

public class LoginModel {
  public Integer loginSelect(String username, String password) {
    Database db = new Database();
    List<String> serverCredentials = db.select("SELECT id, username, password FROM user WHERE username = '%s' AND password = '%s'".formatted(username, password));
    return Integer.parseInt(serverCredentials.getFirst());
  }
}
