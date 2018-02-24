package service;

import dao.Access;
import domain.Client;
import domain.Item;
import domain.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

    private Scanner scan = new Scanner(System.in);
    private Access access;

    public Service(Access access) {
        this.access = access;
    }

    public Service() throws SQLException, ClassNotFoundException {
        this.access = new Access();
    }

    public void showClientMenu() throws SQLException {
        int opt;
        String name, lastname, desc;

        do {
            System.out.println("1. Add new client");
            System.out.println("2. Update client");
            System.out.println("3. Delete client");
            System.out.println("4. Show all clients");
            System.out.println("5. Back to main menu");
            System.out.println("Choose option: ");
            opt = scan.nextInt();
            switch (opt) {
                case 1:
                    int deleted = 0;
                    System.out.println("Name: ");
                    name = scan.next();
                    System.out.println("Last name: ");
                    lastname = scan.next();
                    System.out.println("Description: ");
                    desc = scan.next();
                    System.out.println("DB State: ( not deleted = 0, deleted = 1");
                    //Falta validar valores!!!
                    deleted = scan.nextInt();
                    access.addNewClient(name, lastname, desc, deleted);
                    break;

                case 2:
                    access.getAllClients();
                    System.out.println("Insert the ID of the client you want to update: ");
                    long id = scan.nextLong();
                    if (access.validateClient(id) == true) {
                        System.out.println("Please, insert the new values: ");
                        System.out.println("Name: ");
                        name = scan.next();
                        System.out.println("Last name: ");
                        lastname = scan.next();
                        System.out.println("Description: ");
                        desc = scan.next();
                        System.out.println("DB State: ( not deleted = 0, deleted = 1");
                        //Falta validar valores!!!
                        deleted = scan.nextInt();
                        access.updateClient(id, name, lastname, desc, deleted);
                    } else {
                        System.out.println("The client does not exists");
                    }

                    break;

                case 3:
                    access.getAllClients();
                    System.out.println("Insert the ID of the client you want to delete: ");
                    id = scan.nextLong();
                    if (access.validateClient(id) == true) {
                        System.out.println("Are you sure you want to delete this client? ");
                        System.out.println("Y/N");
                        char option = scan.next().charAt(0);
                        if (option == 'y' || option == 'Y') {
                            access.deleteClient(id);
                            System.out.println("The client was deleted..");
                        } else {
                            System.out.println("The client was not deleted..");
                        }
                    } else {
                        System.out.println("The client does not exists");
                    }
                    break;

                case 4:
                    access.getAllClients();
                    break;

                case 5:

                    break;

            }


        }
        while (opt != 5);
    }


    public void showOrderMenu() throws SQLException {
        int opt;
        long selected_id;
        do {
            System.out.println("1. New order");
            System.out.println("2. Update order");
            System.out.println("3. Delete order");
            System.out.println("4. Show all orders");
            System.out.println("5. Back to main menu");
            System.out.println("Choose option: ");
            opt = scan.nextInt();
            switch (opt) {
                case 1:
                    int deleted = 0;
                    access.getAllClients();
                    System.out.println("Select the id of the client: ");
                    selected_id = scan.nextLong();
                    if (access.validateClient(selected_id) == true) {
                        System.out.println("Adding items to the order: 'ca' to cancell");
                        List<Item> listItems = new ArrayList<Item>();
                        String item_name = "";
                        int parar = 1;
                        while (parar == 1) {
                            System.out.println("Item name: ");
                            item_name = scan.next();
                            Item item = new Item(1, item_name);
                            listItems.add(item);
                            System.out.println("Stop? 0 yes 1 no");
                            parar = scan.nextInt();
                        }
                        System.out.println("Adding items has finished, please, insert the amount of the order: ");
                        float amount = scan.nextFloat();
                        access.newOrder(listItems, amount, selected_id);
                        //access.getOrder() ;
                    } else {
                        System.out.println("The client does not exists");
                    }

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    access.showAllOrders();
                    break;

                case 5:

                    break;

            }


        }
        while (opt != 5);
    }
}
