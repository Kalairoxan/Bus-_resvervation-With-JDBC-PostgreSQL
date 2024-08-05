package org.SpringKalai;

import java.sql.*;

public class BusDAO {

    public void dispalyBusInfo() throws SQLException {
        String query = "Select * from bus";
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BusResrv","postgres","7973");
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);

        while (resultSet.next()){
            System.out.println("Bus No"+resultSet.getInt(1));
            if(!resultSet.getBoolean(2)) {
                System.out.println("AC: AC/NO");
            } else
                System.out.println("AC : AC/yes");
            System.out.println("Capacity: "+resultSet.getInt(3));
        }
        System.out.println("-----------------------------------------------");
    }

    public int getCapacity(int id) throws SQLException {
        String query = "Select capacity from bus where id="+id;
        Connection con = DbConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet resultSet =st.executeQuery(query);
        resultSet.next();
        return resultSet.getInt(1);
    }
}
