package com.github.matheusvizzaccaro.mycalc;

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

            gson.toJson(calcCode, fileWriter);
            fileWriter.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
