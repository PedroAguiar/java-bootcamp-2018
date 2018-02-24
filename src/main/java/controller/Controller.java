package controller;

import domain.Client;
import dao.Access;
import service.Service;

import java.sql.SQLException;

public class Controller {

    private Service service;

    public Controller() throws SQLException, ClassNotFoundException {
        this.service = new Service();
    }

    public Controller( Service service ){
        this.service = service;
    }

    public void clientMenu() throws SQLException {
        service.showClientMenu();
    }

    public void orderMenu() throws SQLException{
        service.showOrderMenu();
    }

}
