package com.globant.dao;

import com.globant.db.ConnectionSingleton;
import com.globant.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private Connection connection;
    private ServiceDao servDao;

    public ClientDao() {

    }

    private void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.connection  = ConnectionSingleton.getInstance().getConnection();
    }

    private void disconnect() throws SQLException {
        if (this.connection != null && this.connection.isClosed()) {
            this.connection.close();
        }
    }

    public boolean insertClient(Client client) throws SQLException {
        String sql = "INSERT INTO client (firstName, lastName, description) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getDescription());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Client> listAllClients() throws SQLException {
        List<Client> listClient = new ArrayList<>();

        String sql = "SELECT * FROM client";

        connect();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idClient");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String description = resultSet.getString("description");

            Client client = new Client(id, firstName, lastName, description);
            listClient.add(client);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listClient;
    }

    public boolean deleteClient(Client client) throws SQLException {
        String sql = "DELETE FROM client where idClient = ?";

        connect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, client.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateClient(Client client) throws SQLException {
        String sql = "UPDATE client SET firstName = ?, lastName = ?, description = ?";
        sql += " WHERE idClient = ?";
        connect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getDescription());
        statement.setInt(4, client.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Client getClient(int id) throws SQLException {
        Client client = null;
        String sql = "SELECT * FROM client WHERE idClient = ?";

        connect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String description = resultSet.getString("description");

            client = new Client(id, firstName, lastName, description);
        }

        resultSet.close();
        statement.close();

        return client;
    }
}
