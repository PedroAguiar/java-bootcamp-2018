package com.globant.servlet;

import com.globant.controller.ClientController;
import com.globant.controller.ItemController;
import com.globant.controller.OrderController;
import com.globant.controller.PaymentController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 *
 * @lastName www.codejava.net
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientController clientCont = new ClientController();
    private OrderController orderCont = new OrderController();
    private ItemController itemCont = new ItemController();
    private PaymentController paymentCont = new PaymentController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = new StringBuilder(request.getContextPath())
                .append(request.getServletPath())
                .toString();

        try {
            switch (action) {
                case "/ShoppingCart-2.0/new":
                    clientCont.showNewForm(request, response);
                    break;
                case "/ShoppingCart-2.0/newOrder":
                    orderCont.showNewForm(request, response);
                    break;
                case "/ShoppingCart-2.0/newItem":
                    itemCont.showNewForm(request, response);
                    break;
                case "/ShoppingCart-2.0/newPayment":
                    paymentCont.showNewForm(request, response);
                    break;
                case "/ShoppingCart-2.0/insert":
                    clientCont.insert(request, response);
                    break;
                case "/ShoppingCart-2.0/insertOrder":
                    orderCont.insert(request, response);
                    break;
                case "/ShoppingCart-2.0/insertItem":
                    itemCont.insert(request, response);
                    break;
                case "/ShoppingCart-2.0/insertPayment":
                    paymentCont.insert(request, response);
                    break;
                case "/ShoppingCart-2.0/delete":
                    clientCont.delete(request, response);
                    break;
                case "/ShoppingCart-2.0/deleteOrder":
                    orderCont.delete(request, response);
                    break;
                case "/ShoppingCart-2.0/deleteItem":
                    itemCont.delete(request, response);
                    break;
                case "/ShoppingCart-2.0/deletePayment":
                    paymentCont.delete(request, response);
                    break;
                case "/ShoppingCart-2.0/edit":
                    clientCont.showEditForm(request, response);
                    break;
                case "/ShoppingCart-2.0/editOrder":
                    orderCont.showEditForm(request, response);
                    break;
                case "/ShoppingCart-2.0/editItem":
                    itemCont.showEditForm(request, response);
                    break;
                case "/ShoppingCart-2.0/editPayment":
                    paymentCont.showEditForm(request, response);
                    break;
                case "/ShoppingCart-2.0/update":
                    clientCont.update(request, response);
                    break;
                case "/ShoppingCart-2.0/updateOrder":
                    orderCont.update(request, response);
                    break;
                case "/ShoppingCart-2.0/updateItem":
                    itemCont.update(request, response);
                    break;
                case "/ShoppingCart-2.0/updatePayment":
                    paymentCont.update(request, response);
                    break;
                case "/ShoppingCart-2.0/options":
                    clientCont.showOptionForm(request, response);
                    break;
                case "/ShoppingCart-2.0/optionsOrder":
                    orderCont.showOptionForm(request, response);
                    break;
                case "/ShoppingCart-2.0/":
                    clientCont.listClient(request, response);
                    break;
                case "/ShoppingCart-2.0/listOrder":
                    orderCont.listOrder(request, response);
                    break;
                case "/ShoppingCart-2.0/listItem":
                    itemCont.listItem(request, response);
                    break;
                case "/ShoppingCart-2.0/listPayment":
                    paymentCont.listPayment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
