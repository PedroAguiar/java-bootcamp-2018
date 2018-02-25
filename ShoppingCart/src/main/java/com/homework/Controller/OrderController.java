package com.homework.Controller;


import com.homework.Dao.OrderDao;
import com.homework.Model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class OrderController {
    private OrderDao orderDAO;

    public OrderController() {
    }

    public void init(String jdbcURL, String jdbcUsername, String jdbcPassword ) {
        orderDAO = new OrderDao(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void showOptionForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order existingOrder = orderDAO.getOrder(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderMenu.jsp");
        request.setAttribute("order", existingOrder);
        dispatcher.forward(request, response);
    }

    public void listOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idClient = Integer.parseInt(request.getParameter("id"));
        List<Order> listOrder = orderDAO.listAllOrders(idClient);
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderList.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idClient", ""+idClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderForm.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order existingOrder = orderDAO.getOrder(id);
        request.setAttribute("order", existingOrder);
        request.setAttribute("idClient", ""+existingOrder.getIdClient());
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderForm.jsp");
        dispatcher.forward(request, response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int idClient = Integer.parseInt(request.getParameter("idClient"));

        Order newOrder = new Order(name, idClient);
        orderDAO.insertOrder(newOrder);
        response.sendRedirect("listOrder?id="+idClient);
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int idClient = Integer.parseInt(request.getParameter("idClient"));

        Order order = new Order(id, name, idClient);
        orderDAO.updateOrder(order);
        response.sendRedirect("listOrder?id="+idClient);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = new Order(id);
        orderDAO.deleteOrder(order);
        response.sendRedirect("listOrder?id="+order.getIdClient());

    }

}


