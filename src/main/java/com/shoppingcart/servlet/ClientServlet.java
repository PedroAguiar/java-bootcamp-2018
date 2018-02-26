package com.shoppingcart.servlet;

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

@WebServlet(name = "ClientServlet")
public class ClientServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    private static final String LIST_CLIENT_ATTRIBUTE = "listClient";
    private static final String LIST_CLIENT_JSP = "ClientList.jsp";
    private static final String CLIENT_FORM_JSP = "ClientForm.jsp";
    private static final String CLIENT_ID_PARAMETER = "id";
    private static final String CLIENT_PARAMETER = "client";
    private static final String CLIENT_NAME_PARAMETER = "name";
    private static final String CLIENT_LAST_NAME_PARAMETER = "lastName";
    private static final String CLIENT_DESCRIPTION_PARAMETER = "description";
    private static final String LIST_PAGE = "list";

    private ClientDAO clientDAO;



    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        clientDAO = new ClientDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertClient(request, response);
                    break;
                case "/delete":
                    deleteClient(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateClient(request, response);
                    break;
                default:
                    listClient(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute(LIST_CLIENT_ATTRIBUTE, listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_CLIENT_JSP);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(CLIENT_FORM_JSP);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(CLIENT_ID_PARAMETER));
        Client existingClient = clientDAO.getClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(CLIENT_FORM_JSP);
        request.setAttribute(CLIENT_PARAMETER, existingClient);
        dispatcher.forward(request, response);

    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter(CLIENT_NAME_PARAMETER);
        String lastname = request.getParameter(CLIENT_LAST_NAME_PARAMETER);
        String description = request.getParameter(CLIENT_DESCRIPTION_PARAMETER);

        Client client = new Client(name, lastname, description);
        clientDAO.insertClient(client);
        response.sendRedirect(LIST_PAGE);
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id = Integer.parseInt(request.getParameter(CLIENT_ID_PARAMETER));
        String name = request.getParameter(CLIENT_NAME_PARAMETER);
        String last_name = request.getParameter(CLIENT_LAST_NAME_PARAMETER);

        Client client = new Client(id, name, last_name);
        clientDAO.updateClient(client);
        response.sendRedirect(LIST_PAGE);
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter(CLIENT_ID_PARAMETER));

        Client client = new Client(id);
        clientDAO.deleteClient(client);
        response.sendRedirect(LIST_PAGE);

    }

}
