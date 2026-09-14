package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUpModel {
  public Boolean insertUser(String username, String password) {
    Database db=new Database();
    Connection conn=db.createConnection();
    try(PreparedStatement preparedStatement=conn.prepareStatement("INSERT INTO user(id, username, password) VALUES (default, ?, ?);")) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);

      if(preparedStatement.executeUpdate() > 0) {
        return true;
      } else {
        return false;
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
