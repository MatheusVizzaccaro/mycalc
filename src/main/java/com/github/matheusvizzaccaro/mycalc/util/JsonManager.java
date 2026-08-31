package com.github.matheusvizzaccaro.mycalc.util;

import com.github.matheusvizzaccaro.mycalc.db.Database;
import com.google.gson.Gson;

import java.io.FileWriter;

public class JsonManager {
    public void readJson() {
        //To do wip
    }

    public void exportJson(CalcCode calcCode) {
        try {
            FileWriter fileWriter = new FileWriter("calc.json");
            Gson gson = new Gson();

            gson.toJson(calcCode);
            fileWriter.close();
            Database db = new Database();

            db.createConnection();
            db.insert(gson.toJson(calcCode));
            db.closeConnection();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
