package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.database.Database;
import com.github.matheusvizzaccaro.mycalc.view.SignUp;

//TODO: trocar os parametros para passar uma classe SignUp.
public class SignUpModel {
  public Boolean insertUser(SignUp signUp) {
    Database db=new Database();
      return db.execute("INSERT INTO user(id, username, password) VALUES (default, ?, ?);", new String[]{signUp.getUsername(), signUp.getPassword()});
  }
}
