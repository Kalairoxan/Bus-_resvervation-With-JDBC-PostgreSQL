package org.SpringKalai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
     private static final String url = "jdbc:postgresql://localhost:5432/BusResrv";
     private static final String username = "postgres";
     private static final String password = "7973";

public static Connection getConnection() throws SQLException {
         return DriverManager.getConnection(url,username,password);
     }
}
