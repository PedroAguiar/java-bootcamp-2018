

package com.globant.dao;

import com.globant.db.DBConnection;
import com.globant.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements DataAccessObject<Client> {

    private static final String CREATE = "INSERT INTO client(firstName, lastName, description) VALUES (?, ?, ?)";
    private static final String READ = "SELECT * FROM client WHERE IdClient=?";
    private static final String UPDATE = "UPDATE client SET firstName =?, lastName=?, description= ? WHERE idClient=?";
    private static final String DELETE = "DELETE FROM client WHERE idClient=?";
    private static final String READ_ALL = "SELECT * FROM client";

    public Client create( Client client ) {

        try {
            DBConnection dbConnection = DBConnection.getInstance ( );
            Connection connection = dbConnection.getConnection ( );
            PreparedStatement statement = connection.prepareStatement (CREATE);
            statement.setString (1, client.getName ( ));
            statement.setString (2, client.getSurname ( ));
            statement.setString (3, client.getDescription ( ));

            ResultSet resultset = statement.executeQuery ( );
            String name = resultset.getString ("firsName");
            String lastname = resultset.getString ("lastName");
            String description = resultset.getString ("description");
            int clientid = resultset.getInt ("idClient");


            return new Client ( clientid,name, lastname, description);



        } catch (SQLException e) {
            System.out.print ("error: client could not be created "+e.getMessage());

        }
        return null;

    }
    public Client read( int id) {

        try {
            DBConnection dbConnection = DBConnection.getInstance ( );
            Connection connection = dbConnection.getConnection ( );
            PreparedStatement statement = connection.prepareStatement (READ);
            statement.setInt (1, id);

            ResultSet resultset = statement.executeQuery ( );
            String name = resultset.getString ("firsName");
            String lastname = resultset.getString ("lastName");
            String description = resultset.getString ("description");
            int clientid = resultset.getInt ("idClient");

            return  new Client (clientid, name, lastname, description);

        } catch (SQLException e) {
            System.out.print ("error: client not found "+e.getMessage());
        }
        return null;
    }
    public Client update( Client client){
        try {
            DBConnection dbConnection = DBConnection.getInstance ( );
            Connection connection = dbConnection.getConnection ( );
            PreparedStatement statement = connection.prepareStatement (UPDATE);
            statement.setString (1, client.getName ( ));
            statement.setString (2, client.getSurname ( ));
            statement.setString (3, client.getDescription ( ));
            statement.setInt (4,client.getId());

            statement.executeQuery ( );
             return client;

        } catch (SQLException e) {
            System.out.print ("error: client has not been updated"+e.getMessage());

        }
        return null;

    }


    public void delete ( int id ){
        try {
            DBConnection dbConnection = DBConnection.getInstance ( );
            Connection connection = dbConnection.getConnection ( );
            PreparedStatement statement = connection.prepareStatement (DELETE);
            statement.setInt (1, id);

             statement.executeQuery ( );
            
        } catch (SQLException e) {
            System.out.print ("error: client not found "+e.getMessage());

        }
    }
    public List <Client> readAll(){

        try {
            DBConnection dbConnection = DBConnection.getInstance ( );
            Connection connection = dbConnection.getConnection ( );
            PreparedStatement statement = connection.prepareStatement (READ_ALL);
            List<Client> clients = new ArrayList<Client>();

            ResultSet resultset = statement.executeQuery ( );
            while (resultset.next ()){
                int idClient = resultset.getInt ("idClient");
                String name = resultset.getString ("firsName");
                String lastname = resultset.getString ("lastName");
                String descrption = resultset.getString ("description");

                Client client= new Client (idClient, name,lastname, descrption);
                

                
                clients.add (client);
            }
           
                
            return clients;

        } catch (SQLException e) {
            System.out.print ("error: customers were not found"+e.getMessage());

        }
        return null;

    }


}
