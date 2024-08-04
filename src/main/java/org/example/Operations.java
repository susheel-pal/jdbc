package org.example;

import java.sql.*;

public class Operations {

    public static void fetchData(ResultSet resultSet) throws SQLException {

        while (resultSet.next()){
            int id = resultSet.getInt("st_id");
            String name = resultSet.getString("stname");
            String email = resultSet.getString("email");
            String phoneNo = resultSet.getString("phoneNo");

            System.out.println(id);
            System.out.println(name);
            System.out.println(email);
            System.out.println(phoneNo);
        }

    }
}
