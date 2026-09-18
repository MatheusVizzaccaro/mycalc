package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.database.Database;
//TODO: trocar os parametros para passar uma classe SignUp.
public class SignUpModel {
  public Boolean insertUser(String username, String password) {
    Database db=new Database();
      return db.execute("INSERT INTO user(id, username, password) VALUES (default, ?, ?);", new String[]{username, password});
  }
}
