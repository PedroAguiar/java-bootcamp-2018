package com.homework.Dao;

import com.homework.Model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {
    private String jdbcURL;
    private String jdbcUseramount;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public PaymentDao(String jdbcURL, String jdbcUseramount, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUseramount = jdbcUseramount;
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
                    jdbcURL, jdbcUseramount, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertPayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO shoppingcart.payment(amount, idOrder_fk) VALUES (?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, payment.getAmount());
        statement.setInt(2, payment.getIdOrder());


        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Payment> listAllPayments() throws SQLException {
        List<Payment> listPayment = new ArrayList<>();

        String sql = "SELECT * FROM shoppingcart.payment";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("idPayment");
            Float amount = Float.parseFloat(resultSet.getString("amount"));
            int idOrder = resultSet.getInt("idOrder_fk");

            Payment payment = new Payment(id, amount, idOrder);
            listPayment.add(payment);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listPayment;
    }

    public boolean deletePayment(Payment payment) throws SQLException {
        String sql = "DELETE FROM shoppingcart.payment where idPayment = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, payment.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updatePayment(Payment payment) throws SQLException {
        String sql = "UPDATE shoppingcart.payment SET amount = ?";
        sql += " WHERE idPayment = ?";
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
        String sql = "SELECT * FROM shoppingcart.payment WHERE idPayment = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Float amount = Float.parseFloat(resultSet.getString("amount"));
            int idOrder = resultSet.getInt("idOrder_fk");
            payment = new Payment(id, amount, idOrder);
        }

        resultSet.close();
        statement.close();

        return payment;
    }
}
