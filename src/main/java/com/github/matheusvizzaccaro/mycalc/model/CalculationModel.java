package com.github.matheusvizzaccaro.mycalc.model;

import com.github.matheusvizzaccaro.mycalc.database.Database;
import com.github.matheusvizzaccaro.mycalc.util.Calculation;
import com.github.matheusvizzaccaro.mycalc.view.Session;

import java.util.List;

public class CalculationModel {
  public Boolean insertCalculation(Calculation calculation, Session session) {
    if(calculation == null) {
      return null;
    }

    Database database = new Database();
    return database.execute("INSERT INTO calculation(id, title, description, code, datetime_creation, user_id) VALUES (default, ?, ?, ?, CURRENT_TIMESTAMP(), ?)", new String[]{calculation.getTitle(), calculation.getDescription(),  calculation.getCalcCode(), String.valueOf(session.getId())});
  }

  public List<String> getCalculations(Session session) {
    if(session == null) {
      return null;
    }
    Database database = new Database();
    return database.select("SELECT code, title, description, datetime_creation FROM calculation WHERE user_id = ?", new String[]{String.valueOf(session.getId())});
  }
}
