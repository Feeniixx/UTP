package zad1;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    private final String url;
    private final TravelData travelData;
    private Statement st;

    public Database(String url, TravelData travelData) {
        this.url = url;
        this.travelData = travelData;
    }

    public void create() {
        connectDatabase();
        createTable();
        travelData.guiList.forEach(this::insetrData);
    }

    private void connectDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection dbCon = DriverManager.getConnection(url);
            st = dbCon.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        String crt = "CREATE TABLE Offers (\n" + "country varchar2(26)  NOT NULL,\n" + "departureDay varchar2(10) NOT NULL,\n" + "returnDay varchar2(10)  NOT NULL,\n" + "place varchar2(10)  NOT NULL,\n" + "price varchar2(15)  NOT NULL,\n" + "currencySymbol varchar2(3)  NOT NULL\n" + ")";
        try {
            st.executeUpdate(crt);
        } catch (SQLException e) {
            try {
                st.executeUpdate("DROP TABLE Offers");
                createTable();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void insetrData(Country country) {
        try {
            String insert = "INSERT INTO Offers (country, departureDay, returnDay, place, price, currencySymbol)" + "VALUES ('" + country.getCountry() + "', '" + country.getDepartureDay()+"', '" + country.getReturnDay()+"', '" + country.getPlace()+"', '" + country.getPrice()+"', '" + country.getCurrencySymbol() + "')";
            st.executeUpdate(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showGui() {
        SwingUtilities.invokeLater(
                ()->new GUI((ArrayList)(travelData.guiList))
        );
    }
}

