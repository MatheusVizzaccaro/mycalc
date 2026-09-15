package com.github.matheusvizzaccaro.mycalc.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {
  Dotenv dotenv = Dotenv.load();
  private String URL = dotenv.get("DB_URL");
  private String username = dotenv.get("DB_USER");
  private String password = dotenv.get("DB_PASSWORD");

  public Connection createConnection() {
    try {
      Connection connection = DriverManager.getConnection(URL, username, password);
      return connection;
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  public void closeConnection(Connection conn) {
    try {
      conn.close();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public boolean insert(String query) {
    Connection connection = createConnection();
    try(PreparedStatement preparedStatement=conn.prepareStatement(query)) {

      if(preparedStatement.executeUpdate() > 0) {
        closeConnection(connection);
        return true;
      } else {
        closeConnection(connection);
       return false;
      }
    } catch(Exception e) {
      closeConnection(connection);
      System.out.println(e.getMessage());
    }
    return false;
  }
}
