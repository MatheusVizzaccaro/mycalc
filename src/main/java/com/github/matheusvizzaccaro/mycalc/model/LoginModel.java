package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModel {
  public Integer loginSelect(String username, String password) {
    Database db = new Database();
    db.select("SELECT id, username, password FROM user WHERE username = ? AND password = ?");
  }
}
