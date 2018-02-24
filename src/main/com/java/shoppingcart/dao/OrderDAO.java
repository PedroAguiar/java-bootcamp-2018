package main.com.java.shoppingcart.dao;

import main.com.java.shoppingcart.entities.Order;
import main.com.java.shoppingcart.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
        this.jdbcConnection = jdbcConnection;
    }

    public boolean insertOrder(Order order) throws SQLException {
        String sql = "INSERT INTO order (name) VALUES ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, order.getName());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        connection.disconnect();

        return rowInserted;
    }

    public List<Order> listAllOrders(Client client) throws SQLException {
        List<Order> listOrder = new ArrayList<>();

        String sql = "SELECT * FROM `order` WHERE idOrder = ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, client.getId());
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idOrder");
            String name = resultSet.getString("name");

            Order order = new Order(id , name);
            listOrder.add(order);
        }

        resultSet.close();
        statement.close();

        connection.disconnect();

        return listOrder;
    }

    public boolean deleteOrder(Client client) throws SQLException {
        String sql = "DELETE FROM order where idOrder = ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, client.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();

        connection.disconnect();

        return rowDeleted;
    }

    public boolean updateOrder(Order order) throws SQLException {
        String sql = "UPDATE order SET name = ? WHERE idOrder = ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, order.getName());
        statement.setInt(2, order.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        connection.disconnect();

        return rowUpdated;
    }

    public Order getOrder(int id) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM order WHERE idOrder = ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");

            order = new Order(id, name);
        }

        resultSet.close();
        statement.close();

        connection.disconnect();

        return order;
    }
}
