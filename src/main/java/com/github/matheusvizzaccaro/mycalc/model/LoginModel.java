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
    try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, username, password FROM user WHERE username = ? AND password = ?")) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if(resultSet.next()){
          Integer id = resultSet.getInt("id");
          String r_username = resultSet.getString("username");
          String r_password = resultSet.getString("password");
          db.closeConnection(conn);

          Session session = new Session(id, r_username, r_password, true);
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
