package main.java.Controller;

import main.java.Dao.ItemDao;
import main.java.Model.Item;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ItemController {
    private ItemDao itemDAO;

    public ItemController() {
    }

    public void init(String jdbcURL, String jdbcUsername, String jdbcPassword ) {
        itemDAO = new ItemDao(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void showOptionForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Item existingItem = itemDAO.getItem(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ItemMenu.jsp");
        request.setAttribute("order", existingItem);
        dispatcher.forward(request, response);
    }

    public void listItem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Item> listItem = itemDAO.listAllItems();
        request.setAttribute("listItem", listItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ItemList.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idOrder = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idOrder", ""+idOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ItemForm.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Item existingItem = itemDAO.getItem(id);
        request.setAttribute("order", existingItem);
        request.setAttribute("idOrder", ""+existingItem.getIdOrder());
        RequestDispatcher dispatcher = request.getRequestDispatcher("ItemForm.jsp");
        dispatcher.forward(request, response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        Item newItem = new Item(name, idOrder);
        itemDAO.insertItem(newItem);
        response.sendRedirect("listItem?id="+newItem.getIdOrder());

    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        Item item = new Item(id, name, idOrder);
        itemDAO.updateItem(item);
        response.sendRedirect("listItem?id="+item.getIdOrder());

    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Item item = new Item(id);
        itemDAO.deleteItem(item);
        response.sendRedirect("listItem?id="+item.getIdOrder());

    }

}


