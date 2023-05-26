package com.example.demo;
import eu.hansolo.toolbox.observables.ObservableList;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class DataAccessor {

    private static final DataAccessor da = new DataAccessor("jdbc:postgresql://10.0.91.123:5432/TMC", "root", "zaq!23");
    private Connection connection;
    public static DataAccessor getDataAccessor(){
        return da;
    }
    private DataAccessor(String dbUrl, String user, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException ignored) {}
    }

    //метод, возвращающий данные
    public List<Items> getItems() throws SQLException {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM items"); //запрос executeQuery - если селект, executeUpdate - если все остальное

        List<Items> il = new ObservableList<>();
        while(rs.next()){
            int id = rs.getInt("item_id");//откуда брать
            String sn = rs.getString("SN");
            String itn = rs.getString("item_name");
            Items item = new Items(id, sn, itn);
            il.add(item);
        }
        return il;
    }
}
