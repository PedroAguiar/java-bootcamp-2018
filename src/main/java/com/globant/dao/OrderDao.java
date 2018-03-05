package com.globant.dao;

import com.globant.db.ConnectionSingleton;
import com.globant.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private Connection jdbcConnection;
    public OrderDao() {
    }


    private void connect() throws SQLException {
        this.jdbcConnection  = ConnectionSingleton.getInstance().getConnection();
    }

    private void disconnect() throws SQLException {
        if (this.jdbcConnection != null && this.jdbcConnection.isClosed()) {
            this.jdbcConnection.close();
        }
    }

    public boolean insertOrder(Order order) throws SQLException {
        String sql = "INSERT INTO shoppingcart.order (nameOrd, idClient_fk) VALUES (?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, order.getName());
        statement.setInt(2, order.getIdClient());


        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Order> listAllOrders() throws SQLException {
        List<Order> listOrder = new ArrayList<>();

        String sql = "SELECT * FROM shoppingcart.order";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idOrder");
            String name = resultSet.getString("nameOrd");
            int idClient = resultSet.getInt("idClient_fk");

            Order order = new Order(id, name, idClient);
            listOrder.add(order);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOrder;
    }

    public List<Order> listAllOrders(int idCli) throws SQLException {
        List<Order> listOrder = new ArrayList<>();

        String sql = "SELECT * FROM shoppingcart.order Where idClient_fk = ?";

        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, idCli);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("idOrder");
            String name = resultSet.getString("nameOrd");
            int idClient = resultSet.getInt("idClient_fk");

            Order order = new Order(id, name, idClient);
            listOrder.add(order);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOrder;
    }

    public boolean deleteOrder(Order order) throws SQLException {
        String sql = "DELETE FROM shoppingcart.order where idOrder = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, order.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateOrder(Order order) throws SQLException {
        String sql = "UPDATE shoppingcart.order SET nameOrd = ?";
        sql += " WHERE idOrder = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, order.getName());
        statement.setInt(2, order.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Order getOrder(int id) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM shoppingcart.order WHERE idOrder = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("nameOrd");
            int idClient = resultSet.getInt("idClient_fk");
            order = new Order(id, name, idClient);
        }

        resultSet.close();
        statement.close();

        return order;
    }
}
