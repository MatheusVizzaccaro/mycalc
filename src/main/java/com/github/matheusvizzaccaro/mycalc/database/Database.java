package com.github.matheusvizzaccaro.mycalc.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
  Dotenv dotenv = Dotenv.load();
  private String URL = dotenv.get("DB_URL");
  private String username = dotenv.get("DB_USER");
  private String password = dotenv.get("DB_PASSWORD");

  private Connection createConnection() {
    try {
      Connection connection = DriverManager.getConnection(URL, username, password);
      return connection;
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  private void closeConnection(Connection conn) {
    try {
      conn.close();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private boolean executeDML(String query) {
    Connection connection = createConnection();
    try(PreparedStatement preparedStatement=connection.prepareStatement(query)) {

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

  public boolean execute(String query) {
    return executeDML(query);
  }

  //pode retornar uma List<String>
  public ResultSet select(String query) {
    Connection connection = createConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if(resultSet.next()){
          return resultSet;
        } else {
          return null;
        }
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
