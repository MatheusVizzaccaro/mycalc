package com.github.matheusvizzaccaro.mycalc.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
  Dotenv dotenv = Dotenv.load();
  private String URL = dotenv.get("DB_URL");
  private String username = dotenv.get("DB_USER");
  private String password = dotenv.get("DB_PASSWORD");

  void createConnection() {
    try {
      Connection connection = DriverManager.getConnection(URL, username, password);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  void closeConnection(Connection conn) {
    try {
      conn.close();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
