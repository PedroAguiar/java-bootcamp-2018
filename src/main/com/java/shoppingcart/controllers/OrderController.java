package main.com.java.shoppingcart.controllers;


import main.com.java.shoppingcart.dao.OrderDAO;
import main.com.java.shoppingcart.entities.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "OrderController")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;

    public void init(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        orderDAO = new OrderDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void showOptionForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderDAO.getOrder(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("menuOrder.jsp");
        request.setAttribute("order", order);
        dispatcher.forward(request, response);
    }

    public void listOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idClient = Integer.parseInt(request.getParameter("id"));
        List<Order> listOrder = orderDAO.listAllOrders(idClient);
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listOrder.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idClient", ""+idClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("newOrder.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderDAO.getOrder(id);
        request.setAttribute("order", order);
        request.setAttribute("idClient", ""+order.getIdClient());
        RequestDispatcher dispatcher = request.getRequestDispatcher("newOrder.jsp");
        dispatcher.forward(request, response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int idClient = Integer.parseInt(request.getParameter("idClient"));

        Order newOrder = new Order(name, idClient);
        orderDAO.insertOrder(newOrder);
        response.sendRedirect("listOrder");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int idClient = Integer.parseInt(request.getParameter("idClient"));

        Order order = new Order(id, name, idClient);
        orderDAO.updateOrder(order);
        response.sendRedirect("listOrder");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = new Order(id);
        orderDAO.deleteOrder(order);
        response.sendRedirect("listOrder");

    }

}
