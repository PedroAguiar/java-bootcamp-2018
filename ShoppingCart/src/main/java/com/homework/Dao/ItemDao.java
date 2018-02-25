package com.homework.Dao;

import com.homework.Model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ItemDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
        String sql = "INSERT INTO shoppingcart.item(nameItem, idOrder_fk) VALUES (?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, item.getName());
        statement.setInt(2, item.getIdOrder());


        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Item> listAllItems() throws SQLException {
        List<Item> listItem = new ArrayList<>();

        String sql = "SELECT * FROM shoppingcart.item";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idItem");
            String name = resultSet.getString("nameItem");
            int idOrder = resultSet.getInt("idOrder_fk");

            Item item = new Item(id, name, idOrder);
            listItem.add(item);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listItem;
    }

    public boolean deleteItem(Item item) throws SQLException {
        String sql = "DELETE FROM shoppingcart.item where idItem = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, item.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateItem(Item item) throws SQLException {
        String sql = "UPDATE shoppingcart.item SET nameItem = ?";
        sql += " WHERE idItem = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, item.getName());
        statement.setInt(2, item.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Item getItem(int id) throws SQLException {
        Item item = null;
        String sql = "SELECT * FROM shoppingcart.item WHERE idItem = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("nameItem");
            int idOrder = resultSet.getInt("idOrder_fk");
            item = new Item(id, name, idOrder);
        }

        resultSet.close();
        statement.close();

        return item;
    }
}
