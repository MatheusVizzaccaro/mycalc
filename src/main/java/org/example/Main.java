package org.example;

import list.todo.Calculator;
import list.todo.Database;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Database db = new Database();

        db.createConnection();
        db.insert("CarlosChato");
        db.closeConnection();

        db.createConnection();
        db.select();
        db.closeConnection();
    }
}