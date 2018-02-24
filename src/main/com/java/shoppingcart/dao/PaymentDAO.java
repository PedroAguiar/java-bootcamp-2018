package main.com.java.shoppingcart.dao;

import main.com.java.shoppingcart.entities.Client;
import main.com.java.shoppingcart.entities.Order;
import main.com.java.shoppingcart.entities.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public PaymentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public boolean makePayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payment (amount) VALUES ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, payment.getAmount());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowInserted;
    }

    public List<Payment> showPayment(Integer idOrder) throws SQLException {
        List<Payment> listpayment = new ArrayList<>();

        String sql = "SELECT * FROM `payment` WHERE idOrder_fk = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, idOrder);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idPayment");
            Float amount = resultSet.getFloat("amount");

            Payment payment = new Payment(id , amount);
            listpayment.add(payment);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listpayment;
    }

    public boolean deletePayment(Client client) throws SQLException {
        String sql = "DELETE FROM payment where idPayment = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, client.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowDeleted;
    }

    public boolean updatePayment(Payment payment) throws SQLException {
        String sql = "UPDATE payment SET name = ? WHERE idPayment = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, payment.getAmount());
        statement.setInt(2, payment.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        disconnect();

        return rowUpdated;
    }

    public Payment getPayment(int id) throws SQLException {
        Payment payment = null;
        String sql = "SELECT * FROM payment WHERE idPayment = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Float amount = resultSet.getFloat("amount");

            payment = new Payment(id, amount);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return payment;
    }
}
