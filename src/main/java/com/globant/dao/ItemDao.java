package com.globant.dao;

import com.globant.db.ConnectionSingleton;
import com.globant.model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

    private Connection jdbcConnection;

    public ItemDao() {
    }

    private void connect() throws SQLException {
        this.jdbcConnection  = ConnectionSingleton.getInstance().getConnection();
    }

    private void disconnect() throws SQLException {
        if (this.jdbcConnection != null && this.jdbcConnection.isClosed()) {
            this.jdbcConnection.close();
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
