package com.globant;

import com.globant.db.DBConnection;



import java.sql.Connection;
import java.sql.SQLException;

public class Main {



    public static void main( String[] args){

        try {
            DBConnection shoppingc = DBConnection.getInstance();
            Connection connection = shoppingc.getConnection();
            System.out.println(connection.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
