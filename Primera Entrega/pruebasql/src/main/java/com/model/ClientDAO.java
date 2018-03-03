package com.model;

import java.util.*;
import java.sql.*;


public class ClientDAO {

    private final String SQL_INSERT = "INSERT INTO client(Name,LastName,Description) VALUES(?,?,?)";
    private final String SQL_UPDATE = "UPDATE client SET Name=?, LastName=?, Description=? WHERE idClient=?";
    private final String SQL_DELETE = "DELETE FROM client WHERE idClient=?";
    private final String SQL_SELECT = "SELECT * FROM client WHERE idClient=?";
    private final String SQL_SELECTALL = "SELECT * FROM client";

    public int insert(ClientDTO client) throws SQLException {

        Connection conn = ConnectionJDBC.getConnection();
        int rows = 0;

        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);

        int index = 1;
        stmt.setString(index++,client.getName());
        stmt.setString(index++, client.getLastName());
        stmt.setString(index, client.getDescription());

        System.out.println("Adding client to DB...");

        rows = stmt.executeUpdate();// this returns an int with the number of modified records


        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return rows;

    }

    public int update(ClientDTO client) throws SQLException {

        Connection conn = ConnectionJDBC.getConnection();
        int rows = 0;

        PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);

        int index = 1;
        stmt.setString(index++,client.getName());
        stmt.setString(index++, client.getLastName());
        stmt.setString(index++, client.getDescription());
        stmt.setInt(index, client.getID());

        System.out.println("Updating client to DB...");

        rows = stmt.executeUpdate();// this returns an int with the number of modified records


        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return rows;

    }

    public int delete(ClientDTO client) throws SQLException {

        Connection conn = ConnectionJDBC.getConnection();
        int rows = 0;

        PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);

        int index = 1;
        stmt.setInt(index,client.getID());


        System.out.println("Deleting client to DB...");

        rows = stmt.executeUpdate();// this returns an int with the number of modified records


        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return rows;

    }

    public ClientDTO select(int id) throws SQLException {

        ResultSet rs = null;
        Connection conn = ConnectionJDBC.getConnection();
        int rows = 0;

        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);



        int index = 1;
        stmt.setInt(index, id);

        rs = stmt.executeQuery();

        System.out.println("Searching for client...");

        int idClient = rs.getInt(1);
        String name = rs.getString(2);
        String lastName = rs.getString(3);
        String description = rs.getString(4);

        if(name != null) {

            ClientDTO cl = new ClientDTO(name,lastName,description);
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
            return cl;

        } else {

            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
            return null;
        }
    }

    public ArrayList<ClientDTO> selectAll() throws SQLException {

        Connection conn = ConnectionJDBC.getConnection();
        ArrayList<ClientDTO> clients = new ArrayList<ClientDTO>();


        PreparedStatement stmt = conn.prepareStatement(SQL_SELECTALL);
        ResultSet rs = stmt.executeQuery();


        while (rs.next()) {

            int idClient = rs.getInt(1);
            String name = rs.getString(2);
            String lastName = rs.getString(3);
            String description = rs.getString(4);

            ClientDTO cli = new ClientDTO(name, lastName, description);
            cli.setID(idClient);

            clients.add(cli);

        }

        ConnectionJDBC.close(rs);
        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return clients;

    }
}
