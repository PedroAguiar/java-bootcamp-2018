package main.com.java.shoppingcart.controllers;

import main.com.java.shoppingcart.dao.ItemDAO;
import main.com.java.shoppingcart.entities.Item;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ItemController")
public class ItemController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private ItemDAO itemDAO;

    public void init(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        itemDAO = new ItemDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void showOptionForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Item item = itemDAO.getItem(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("menuItem.jsp");
        request.setAttribute("order", item);
        dispatcher.forward(request, response);
    }

    public void listItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Item> listItem = itemDAO.listAllItems();
        request.setAttribute("listItem", listItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listItems.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idOrder = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idOrder", ""+idOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("newItem.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Item item = itemDAO.getItem(id);
        request.setAttribute("order", item);
        request.setAttribute("idOrder", ""+item.getIdOrder());
        RequestDispatcher dispatcher = request.getRequestDispatcher("newItem.jsp");
        dispatcher.forward(request, response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        Item newItem = new Item(name, idOrder);
        itemDAO.insertItem(newItem);
        response.sendRedirect("listItem");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        Item order = new Item(id, name, idOrder);
        itemDAO.updateItem(order);
        response.sendRedirect("listItem");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Item order = new Item(id);
        itemDAO.deleteItem(order);
        response.sendRedirect("listItem");

    }

}


