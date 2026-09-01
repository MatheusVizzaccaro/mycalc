package com.github.matheusvizzaccaro.mycalc.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
