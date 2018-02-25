package com.homework.Controller;



import com.homework.Dao.ClientDao;
import com.homework.Model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class ClientController {

    private ClientDao clientDAO;

    public ClientController() {
    }

    public void init(String jdbcURL, String jdbcUsername, String jdbcPassword ) {
        clientDAO = new ClientDao(jdbcURL, jdbcUsername, jdbcPassword);
    }


    public void showOptionForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client existingClient = clientDAO.getClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientMenu.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);
    }

    public void listClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientList.jsp");
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client existingClient = clientDAO.getClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);
    }

    public void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String description = request.getParameter("description");

        Client newClient = new Client(firstName, lastName, description);
        clientDAO.insertClient(newClient);
        response.sendRedirect("/");
    }

    public void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String description = request.getParameter("description");

        Client client = new Client(id, firstName, lastName, description);
        clientDAO.updateClient(client);
        response.sendRedirect("/");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client client = new Client(id);
        clientDAO.deleteClient(client);
        response.sendRedirect("/");

    }
}
