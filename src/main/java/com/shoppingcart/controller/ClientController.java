package com.shoppingcart.controller;


import com.shoppingcart.dao.ClientDAO;
import com.shoppingcart.entity.Client;

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
    private static final String ID_PARAMETER = "id";
    private static final String NAME_PARAMETER = "name";
    private static final String LAST_NAME_PARAMETER = "lastName";
    private static final String DESCRIPTION_PARAMETER = "description";
    private static final String CLIENT_ATTRIBUTE = "client";
    private static final String LIST_REDIRECT = "list";
    private static final String LIST_CLIENT_ATTRIBUTE = "listClient";
    private static final String LIST_CLIENTS_JSP = "listClients.jsp";
    private static final String NEW_CLIENT_JSP = "newClient.jsp";

    private ClientDAO clientDAO;

    public void init(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        clientDAO = new ClientDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void listClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute(LIST_CLIENT_ATTRIBUTE, listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_CLIENTS_JSP);
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(NEW_CLIENT_JSP);
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(ID_PARAMETER));
        Client existingClient = clientDAO.getClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(NEW_CLIENT_JSP);
        request.setAttribute(CLIENT_ATTRIBUTE, existingClient);
        dispatcher.forward(request, response);

    }

    public void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter(NAME_PARAMETER);
        String lastname = request.getParameter(LAST_NAME_PARAMETER);
        String description = request.getParameter(DESCRIPTION_PARAMETER);

        Client client = new Client(name, lastname, description);
        clientDAO.insertClient(client);
        response.sendRedirect(LIST_REDIRECT);
    }

    public void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id = Integer.parseInt(request.getParameter(ID_PARAMETER));
        String name = request.getParameter(NAME_PARAMETER);
        String lastName = request.getParameter(LAST_NAME_PARAMETER);
        String description = request.getParameter(DESCRIPTION_PARAMETER);

        Client client = new Client(id, name, lastName, description);
        clientDAO.updateClient(client);
        response.sendRedirect(LIST_REDIRECT);
    }

    public void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter(ID_PARAMETER));

        Client client = new Client(id);
        clientDAO.deleteClient(client);
        response.sendRedirect(LIST_REDIRECT);

    }
}
