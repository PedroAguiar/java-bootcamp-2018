package main.com.java.shoppingcart.dao;

import main.com.java.shoppingcart.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ClientDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertClient(Client client) throws SQLException {
        String sql = "INSERT INTO client (firstName, lastName, description) VALUES (?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, client.getName());
        statement.setString(2, client.getLastname());
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
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Integer id = resultSet.getInt("idClient");
            String name = resultSet.getString("firstName");
            String lastname = resultSet.getString("lastName");
            String description = resultSet.getString("description");
            Client client = new Client(id , name, lastname, description);
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

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, client.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowDeleted;
    }

    public boolean updateClient(Client client) throws SQLException {
        String sql = "UPDATE client SET firstName = ?, lastName = ?, description = ? WHERE idClient = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, client.getId());
        statement.setString(2, client.getName());
        statement.setString(3, client.getLastname());
        statement.setString(4, client.getDescription());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowUpdated;
    }

    public Client getClient(int id) throws SQLException {
        Client client = null;
        String sql = "SELECT * FROM client WHERE idClient = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("firstName");
            String last_name = resultSet.getString("lastName");
            String description = resultSet.getString("description");

            client = new Client(id, name, last_name, description);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return client;
    }
}
