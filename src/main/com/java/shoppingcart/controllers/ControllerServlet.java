package main.com.java.shoppingcart.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    private ClientController clientCont;
    private OrderController orderCont;
    private ItemController itemCont;
    private PaymentController paymentCont;

    public ControllerServlet() {
        clientCont = new ClientController();
        paymentCont = new PaymentController();
        orderCont = new OrderController();
        itemCont = new ItemController();
    }

    public void init() {
        jdbcURL = getServletContext().getInitParameter("jdbcURL");
        jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
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
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.showNewForm(request, response);
                    break;
                case "/newOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.showNewForm(request, response);
                    break;
                case "/newItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.showNewForm(request, response);
                    break;
                case "/newPayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.showNewForm(request, response);
                    break;
                case "/insert":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.insertClient(request, response);
                    break;
                case "/insertOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.insert(request, response);
                    break;
                case "/insertItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.insert(request, response);
                    break;
                case "/insertPayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.makePayment(request, response);
                    break;
                case "/delete":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.deleteClient(request, response);
                    break;
                case "/deleteOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.delete(request, response);
                    break;
                case "/deleteItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.delete(request, response);
                    break;
                case "/edit":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.showEditForm(request, response);
                    break;
                case "/editOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.showEditForm(request, response);
                    break;
                case "/editItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.showEditForm(request, response);
                    break;
                case "/editPayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.showEditForm(request, response);
                    break;
                case "/update":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.updateClient(request, response);
                    break;
                case "/updateOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.update(request, response);
                    break;
                case "/updateItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.update(request, response);
                    break;
                case "/updatePayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.updatePayment(request, response);
                    break;
                case "/optionsOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.showOptionForm(request, response);
                    break;
                case "/":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.listClient(request, response);
                    break;
                case "/list":
                    clientCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    clientCont.listClient(request, response);
                    break;
                case "/listOrder":
                    orderCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    orderCont.listOrder(request, response);
                    break;
                case "/listItem":
                    itemCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    itemCont.listItem(request, response);
                    break;
                case "/listPayment":
                    paymentCont.init(jdbcURL, jdbcUsername, jdbcPassword);
                    paymentCont.listPayment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}