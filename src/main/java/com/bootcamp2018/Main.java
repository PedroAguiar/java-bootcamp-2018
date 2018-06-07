package com.bootcamp2018;

import com.bootcamp2018.Model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Item> listOfItems = new ArrayList<Item>();
    static ArrayList<Order> listOfOrders = new ArrayList<Order>();
    static ArrayList<Client> listOfClients = new ArrayList<Client>();
    static ArrayList<Payment> listOfPayments = new ArrayList<Payment>();
    public static void main(String[] Arg) {
        int op;
        boolean ban;
        addEntities();

        do {

            System.out.println("Menu");
            System.out.println("1.Register Item");
            System.out.println("2.List Items");
            System.out.println("3.Register Order");
            System.out.println("4.List Orders");
            System.out.println("5.Register Client");
            System.out.println("6.List Clients");
            System.out.println("7.Register Payment");
            System.out.println("8.List Payments");
            System.out.println("9.Exit");
            System.out.println("Select: ");
            Scanner scanner = new Scanner(System.in);
            ban = false;

            op = Integer.parseInt(scanner.next());
            switch (op) {

                case 1:
                    while (!ban) {
                        System.out.println("Enter item Id: ");
                        String id = scanner.next();
                        if (isInt(id)) {
                            Item newItem = new Item(Integer.parseInt(id), "");
                            if (!(listOfItems.contains(newItem))) {
                                while (!ban) {
                                    System.out.println("Enter item Name: ");
                                    String name = scanner.next();
                                    if (name != null) {
                                        newItem.setName(name);
                                        listOfItems.add(newItem);
                                        ban = true;
                                    } else {
                                        System.out.println("Please enter a Name");
                                    }
                                }
                            } else {
                                System.out.println("Item Id Already in use");

                            }

                        } else {
                            System.out.println("Please Input A Valid Number");
                        }


                    }

                    break;
                case 2:
                    if (listOfItems.size() > 0) {
                        System.out.println("Existing Items: ");
                        for (Item i : listOfItems
                                ) {
                            System.out.println(i.toString());
                        }
                    } else {
                        System.out.println("There are no items.");
                    }
                    break;
                case 3:
                    if (listOfItems.size() > 0) {
                        while (!ban){
                            System.out.println("Enter Order Id: ");
                            String id = scanner.next();
                            if (isInt(id)) {
                                Order newOrder = new Order(Integer.parseInt(id));
                                if (!(listOfOrders.contains(newOrder))) {
                                    ArrayList<Item> orderItems = new ArrayList<Item>();
                                    while (!ban){
                                        System.out.println("Order Menu");
                                        System.out.println("1.Add Item");
                                        System.out.println("2.List Items");
                                        System.out.println("3.Confirm Order");
                                        System.out.println("4.Cancel Order");
                                        op = Integer.parseInt(scanner.next());
                                        switch (op) {
                                            case 1:
                                                System.out.println("Write item Id: ");
                                                String idItem = scanner.next();
                                                if (isInt(idItem)) {
                                                    Item it = new Item(Integer.parseInt(idItem), "");
                                                    if (listOfItems.contains(it)) {
                                                        if (!orderItems.contains(it)) {
                                                            orderItems.add(listOfItems.get(listOfItems.indexOf(it)));
                                                        } else {
                                                            System.out.println("The Item is already part of the order.");
                                                        }
                                                    } else {
                                                        System.out.println("Item does not exists.");
                                                    }
                                                } else {
                                                    System.out.println("Please enter a number.");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Items in the order: ");
                                                for (Item i : orderItems
                                                        ) {
                                                    System.out.println(i.toString());
                                                }
                                                break;
                                            case 3:
                                                if (orderItems.size() > 0) {
                                                    newOrder.setItems(orderItems);
                                                    listOfOrders.add(newOrder);
                                                }
                                                ban = true;
                                                break;
                                            case 4:
                                                ban = true;
                                                break;
                                        }

                                    }
                                } else {
                                    System.out.println("Order Id: " + id + " already exists.");

                                }

                            } else {
                                System.out.println("Please input a valid number.");
                            }


                        }
                    } else {
                        System.out.println("No Items available");
                    }
                    break;
                case 4:
                    if (listOfOrders.size() > 0 ) {
                        System.out.println("Existing Orders: ");
                        for (Order i : listOfOrders
                                ) {
                            System.out.println(i.toString());
                        }
                    } else {
                        System.out.println("There are no orders.");
                    }

                    break;
                case 5:
                    while (!ban){
                        System.out.println("Enter Client Id: ");
                        String id = scanner.next();
                        if (isInt(id)) {
                            Client newClient = new Client(Integer.parseInt(id));
                            if (!(listOfClients.contains(newClient))) {
                                while (!ban) {
                                    System.out.println("Enter Client Name: ");
                                    String name = scanner.next();
                                    if (name != null) {
                                        while (!ban) {
                                            System.out.println("Enter Client last name: ");
                                            String lastName = scanner.next();
                                            if (lastName != null) {
                                                while (!ban) {
                                                    System.out.println("Enter description: ");
                                                    String description = scanner.next();
                                                    if (description != null) {
                                                        newClient = new Client (Integer.parseInt(id),name,lastName,description);
                                                        listOfClients.add(newClient);
                                                        ban = true;
                                                    } else {
                                                        System.out.println("Please enter a description.");
                                                    }
                                                }
                                            } else {
                                                System.out.println("Please enter a last name.");
                                            }
                                        }
                                    } else {
                                        System.out.println("Please enter a Name.");
                                    }
                                }
                            } else {
                                System.out.println("Client Id already in use.");
                            }
                        } else {
                            System.out.println("Please Input A Valid Number.");
                        }
                    }
                    break;
                case 6:
                    if (listOfClients.size() > 0) {
                        System.out.println("Existing Clients: ");
                        for (Client i : listOfClients
                                ) {
                            System.out.println(i.toString());
                        }
                    } else {
                        System.out.println("There are no Clients.");
                    }
                    break;
                case 7:
                    if (listOfOrders.size() >0 && listOfClients.size() > 0 ) {
                        while (!ban){
                            System.out.println("Enter Payment Id: ");
                            String id = scanner.next();
                            if (isInt(id)) {
                                Payment newPayment = new Payment(Integer.parseInt(id));
                                if (!(listOfPayments.contains(newPayment))) {
                                    while (!ban) {
                                        System.out.println("Enter Order Id: ");
                                        String orderId = scanner.next();
                                        if (isInt(orderId)) {
                                            Order payOrder = new Order(Integer.parseInt(orderId));
                                            if (listOfOrders.contains(payOrder) && !payedOrder(payOrder)) {
                                                payOrder = listOfOrders.get(listOfOrders.indexOf(payOrder));
                                                while (!ban) {
                                                    System.out.println("Enter payment amount: ");
                                                    String amount = scanner.next();
                                                    if (isDouble(amount) && Double.parseDouble(amount) > 0) {
                                                        while (!ban) {
                                                            System.out.println("Enter client id: ");
                                                            String clientId = scanner.next();
                                                            if (isInt(clientId)) {
                                                                Client c = new Client(Integer.parseInt(clientId));
                                                                if (listOfClients.contains(c)) {

                                                                    newPayment = new Payment(Integer.parseInt(id), payOrder, Double.parseDouble(amount));
                                                                    listOfPayments.add(newPayment);
                                                                    listOfClients.get(listOfClients.indexOf(c)).getPayments().add(newPayment);
                                                                    ban = true;
                                                                }
                                                            } else {
                                                                System.out.println("Please enter a valid client.");
                                                            }
                                                        }

                                                    } else {
                                                        System.out.println("Please enter a valid amount.");
                                                    }
                                                }
                                            } else {
                                                System.out.println("That order doesn't exists or is already payed.");
                                            }
                                        } else {
                                            System.out.println("Please enter a number.");
                                        }
                                    }
                                } else {
                                    System.out.println("Payment Id already in use.");
                                }
                            } else {
                                System.out.println("Please Input A Valid Number.");
                            }
                        }
                    } else {
                        System.out.println("Please register an order first.");
                    }
                    break;
                case 8:
                    if (listOfPayments.size() > 0) {
                        System.out.println("Existing Payments: ");
                        for (Payment i : listOfPayments
                                ) {
                            System.out.println(i.toString());
                        }
                    } else {
                        System.out.println("There are no Payments.");
                    }
                    break;
                case 9:
                    break;


            }
        } while (op != 9);
    }

    private static void addEntities() {
        listOfItems.add(new Item(1,"Agua"));
        listOfItems.add(new Item(2,"Pan"));
        listOfItems.add(new Item(3,"Salsa"));
        listOfItems.add(new Item(4,"Carne"));
        listOfItems.add(new Item(5,"Pollo"));
        Order pepe = new Order(1);
        pepe.getItems().add(listOfItems.get(0));
        pepe.getItems().add(listOfItems.get(1));
        pepe.getItems().add(listOfItems.get(2));
        listOfOrders.add(pepe);
        pepe = new Order(2);
        pepe.getItems().add(listOfItems.get(3));
        pepe.getItems().add(listOfItems.get(4));
        listOfOrders.add(pepe);
        pepe = new Order(3);
        pepe.getItems().add(listOfItems.get(0));
        pepe.getItems().add(listOfItems.get(2));
        pepe.getItems().add(listOfItems.get(4));
        listOfOrders.add(pepe);

        Client ramon = new Client (1,"Ramon","Baldez","Don Ramon");
        listOfClients.add(ramon);
    }



    private static boolean payedOrder(Order payOrder) {
        boolean ban = false;
        if (listOfPayments.size() > 0) {
            for (Payment p : listOfPayments
                    ) {
                if (p.getOrder().equals(payOrder)) {
                    ban = true;
                    break;
                }
            }
        }
        return ban;
    }


    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;


    }
    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;


    }

}
