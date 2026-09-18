package com.github.matheusvizzaccaro.mycalc.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Database {
  //TODO: implement new method so it can overwrite ? (setString)
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

  public List<String> select(String query, String[] parameters) {
    List<String> returnList = new ArrayList<>();

    Connection connection = createConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      for(int i=0;i<parameters.length;i++) {
        preparedStatement.setString(i+1, parameters[i]);
      }

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while(resultSet.next()) {
          for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++) {
            returnList.add(resultSet.getString(i));
          }
        }
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
    return returnList;
  }
}
