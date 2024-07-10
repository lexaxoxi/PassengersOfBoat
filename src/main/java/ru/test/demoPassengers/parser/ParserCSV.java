package ru.test.demoPassengers.parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ParserCSV {
    public static void main(String[] args) {
        String urlDB = "jdbc:postgresql://localhost:5432/TestBritanic";
        String userDB = "postgres";
        String passwordDB = "postgres";
        String pathToCsv = "src/main/resources/titanic.csv";
        String line = "";
        JSONArray jsonArray = new JSONArray();



        String createTableTitanic = "CREATE TABLE IF NOT EXISTS titanic ("
                + "id SERIAL PRIMARY KEY, "
                + "Survived BOOLEAN, "
                + "Enum INT, "
                + "Name VARCHAR(255), "
                + "Sex VARCHAR(255), "
                + "Age INT, "
                + "Siblings INT, "
                + "Parents INT, "
                + "Fare DECIMAL(10, 4)"
                +");";
        String insertValues = "INSERT INTO titanic (Survived, Enum, Name, Sex, Age, Siblings, Parents, Fare) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String changeBoolValue = "UPDATE titanic SET Survived = CASE WHEN Survived = '1' THEN true ELSE false END";
//todo преобразовать тип данных выжившего в булеан
        try (Connection con = DriverManager.getConnection(urlDB,userDB,passwordDB);
             Statement stm = con.createStatement();
             PreparedStatement pstm = con.prepareStatement(insertValues);
             BufferedReader br = new BufferedReader(new FileReader(pathToCsv))) {

            stm.execute(createTableTitanic);

            while ((line = br.readLine()) != null) {
               String[] data = line.split(",");
               for (int i = 0; i < data.length; i++) {
                   pstm.setString(i + 1, data[i]);
               }
               pstm.executeUpdate();
            }

            stm.execute(changeBoolValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}