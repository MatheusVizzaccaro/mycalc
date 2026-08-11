package list.todo;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Database {
    Dotenv dotenv = Dotenv.load();
    String url = dotenv.get("DB_URL");
    String username = dotenv.get("DB_USER");
    String password = dotenv.get("DB_PASSWORD");
    String query = "INSERT INTO teste (username) VALUES (?);";
    Connection connection;

    public void createConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insert(String newName) {
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, newName);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void select() {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT USERNAME, id FROM teste;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " - " + rs.getInt(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
