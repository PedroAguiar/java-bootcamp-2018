package main.com.java.shoppingcart.dao;

import main.com.java.shoppingcart.entities.Item;
import main.com.java.shoppingcart.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ItemDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertItem(Item item) throws SQLException {
        String sql = "INSERT INTO item (name) VALUES ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, item.getName());


        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowInserted;
    }

    public List<Item> listAllItems() throws SQLException {
        List<Item> listItems = new ArrayList<>();

        String sql = "SELECT * FROM client";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idItem");
            String name = resultSet.getString("name");

            Item item = new Item(id , name);
            listItems.add(item);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listItems;
    }

    public boolean deleteItem(Item item) throws SQLException {
        String sql = "DELETE FROM item where idItem = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, item.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowDeleted;
    }

    public boolean updateItem(Item item) throws SQLException {
        String sql = "UPDATE client SET firstName = ?, lastName = ?, description = ? WHERE idItem = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, item.getId());
        statement.setString(2, item.getName());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowUpdated;
    }

    public Item getItem(int id) throws SQLException {
        Item item = null;
        String sql = "SELECT * FROM client WHERE idItem = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("firstName");
            String last_name = resultSet.getString("lastName");
            String description = resultSet.getString("description");

            item = new Item(id, name);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return item;
    }
}

