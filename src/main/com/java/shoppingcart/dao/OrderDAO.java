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

    public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
        this.jdbcConnection = jdbcConnection;
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

    public boolean insertOrder(Order order, int idClient) throws SQLException {
        String sql = "INSERT INTO order (name, client_Orders_fk) VALUES (?,?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, order.getName());
        statement.setInt(2, idClient);

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowInserted;
    }

    public List<Order> listAllOrders(int idClient) throws SQLException {
        List<Order> listOrder = new ArrayList<>();

        String sql = "SELECT * FROM `order` WHERE client_Orders_fk = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, idClient);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idOrder");
            String name = resultSet.getString("name");

            Order order = new Order(id , name);
            listOrder.add(order);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOrder;
    }

    public boolean deleteOrder(Order order) throws SQLException {
        String sql = "DELETE FROM order where idOrder = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, order.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowDeleted;
    }

    public boolean updateOrder(Order order) throws SQLException {
        String sql = "UPDATE order SET name = ? WHERE idOrder = ?";

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
        String sql = "SELECT * FROM order WHERE idOrder = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");

            order = new Order(id, name);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return order;
    }
}
