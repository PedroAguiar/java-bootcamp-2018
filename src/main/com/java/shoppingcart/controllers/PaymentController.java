package main.com.java.shoppingcart.controllers;

import main.com.java.shoppingcart.dao.PaymentDAO;
import main.com.java.shoppingcart.entities.Payment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PaymentController")
public class PaymentController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private PaymentDAO paymentDAO;

    public PaymentController() {
    }

    public void init(String jdbcURL, String jdbcUseramount, String jdbcPassword) {
        paymentDAO = new PaymentDAO(jdbcURL, jdbcUseramount, jdbcPassword);
    }

    public void listPayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idOrder = Integer.parseInt(request.getParameter("id"));
        List<Payment> listPayment = paymentDAO.showPayment(idOrder);
        request.setAttribute("listPayment", listPayment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listPayments.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idOrder = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idOrder", ""+idOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentForm.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Payment payment = paymentDAO.getPayment(id);
        request.setAttribute("payment", payment);
        request.setAttribute("idOrder", ""+payment.getIdOrder());
        RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentForm.jsp");
        dispatcher.forward(request, response);
    }

    public void makePayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Float amount = Float.parseFloat(request.getParameter("amount"));
        System.out.println("AMOUNT EN EL BACK "+amount);
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        Payment payment = new Payment(amount, idOrder);
        paymentDAO.makePayment(payment);
        response.sendRedirect("listPayment?id="+payment.getIdOrder());
    }

    public void updatePayment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Float amount = Float.parseFloat(request.getParameter("amount"));
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        Payment payment = new Payment(id, amount, idOrder);
        paymentDAO.updatePayment(payment);
        response.sendRedirect("listPayment?id="+payment.getIdOrder());
    }

}

