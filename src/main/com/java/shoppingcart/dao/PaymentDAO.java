package main.com.java.shoppingcart.dao;

import main.com.java.shoppingcart.entities.Client;
import main.com.java.shoppingcart.entities.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public PaymentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
        this.jdbcConnection = jdbcConnection;
    }

    public boolean insertpayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payment (amount) VALUES ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, payment.getAmount());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        connection.disconnect();

        return rowInserted;
    }

    public List<Payment> listAllpayments(Client client) throws SQLException {
        List<Payment> listpayment = new ArrayList<>();

        String sql = "SELECT * FROM `payment` WHERE idPayment = ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, client.getId());
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idPayment");
            Float amount = resultSet.getFloat("amount");

            Payment payment = new Payment(id , amount);
            listpayment.add(payment);
        }

        resultSet.close();
        statement.close();

        connection.disconnect();

        return listpayment;
    }

    public boolean deletepayment(Client client) throws SQLException {
        String sql = "DELETE FROM payment where idPayment = ?";

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

    public boolean updatepayment(Payment payment) throws SQLException {
        String sql = "UPDATE payment SET name = ? WHERE idPayment = ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, payment.getAmount());
        statement.setInt(2, payment.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        connection.disconnect();

        return rowUpdated;
    }

    public Payment getpayment(int id) throws SQLException {
        Payment payment = null;
        String sql = "SELECT * FROM payment WHERE idPayment = ?";

        connectionJDBC connection;
        connection = new connectionJDBC(jdbcURL, jdbcUsername, jdbcPassword, jdbcConnection);
        connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Float amount = resultSet.getFloat("amount");

            payment = new Payment(id, amount);
        }

        resultSet.close();
        statement.close();

        connection.disconnect();

        return payment;
    }
}
