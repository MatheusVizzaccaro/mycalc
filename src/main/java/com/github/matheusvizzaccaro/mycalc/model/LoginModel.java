package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.util.Database;
import com.github.matheusvizzaccaro.mycalc.view.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModel {
  public Boolean loginSelect(String username, String password) {
    Database db = new Database();
    Connection conn = db.createConnection();
    try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM user WHERE username = ? AND password = ?")) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if(resultSet.next()){
          Integer id = resultSet.getInt("id");
          db.closeConnection(conn);
          Session session = new Session();
          session.setId(id);
          return true;
        } else {
          return false;
        }
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
