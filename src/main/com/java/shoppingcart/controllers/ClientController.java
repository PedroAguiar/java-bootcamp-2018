package main.com.java.shoppingcart.controllers;

import main.com.java.shoppingcart.dao.ClientDAO;
import main.com.java.shoppingcart.entities.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ClientController")
public class ClientController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO;

    public void init(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        clientDAO = new ClientDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void listClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listClients.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("newClient.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client existingClient = clientDAO.getClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("newClient.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);

    }

    public void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String description = request.getParameter("description");

        Client client = new Client(name, lastname, description);
        clientDAO.insertClient(client);
        response.sendRedirect("list");
    }

    public void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String last_name = request.getParameter("lastname");

        Client client = new Client(id, name, last_name);
        clientDAO.updateClient(client);
        response.sendRedirect("list");
    }

    public void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Client client = new Client(id);
        clientDAO.deleteClient(client);
        response.sendRedirect("list");

    }
}
