package com.controller;


import com.model.*;



import java.util.*;




public class Operations {

    private static Scanner sc = new Scanner(System.in);
    private static ClientDAO cliDao = new ClientDAO();
    private static OrderDAO ordDao = new OrderDAO();
    private static ItemDAO itDao = new ItemDAO();


    public static void addClient(){

        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter LastName: ");
        String lastName = sc.nextLine();

        System.out.println("Enter Description: ");
        String description = sc.nextLine();

        ClientDTO cl = new ClientDTO(name,lastName,description);

        try {

            cliDao.insert(cl);

        } catch (Exception e) {

            e.printStackTrace();

        }




    }

    public static void selectClient() throws Exception {

        ClientDTO selectedClient = null;

        ArrayList<ClientDTO> clients = cliDao.selectAll();

        for(int i = 0 ; i < clients.size() ; i++) {

            System.out.println(clients.get(i).toString());

        }

        System.out.println("Select Client by ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for(int i = 0 ; i < clients.size() ; i++) {

            if(id == clients.get(i).getID()) {

                selectedClient = clients.get(i);

            }

        }

        if(selectedClient != null) {

            System.out.println("You selected "+ selectedClient.getName() +" "+selectedClient.getLastName()+" client." );

        } else {

            System.out.println("That client is not on the DB");

        }

        int menuop = 0;

        do {

            System.out.println("\n ***** CLIENT MENU *****");
            System.out.println("1-Delete client");
            System.out.println("2-Update client");
            System.out.println("3-Make a new Order");
            System.out.println("4-List Payments");
            System.out.println("5-Exit client menu");

            menuop = sc.nextInt();
            sc.nextLine();

            switch (menuop) {

                case 1:
                    System.out.println("\n\n****** DELETE CLIENT ******");
                    Operations.deleteClient(selectedClient);


                    break;
                case 2:
                    System.out.println("\n\n****** UPDATE CLIENT ******");
                    Operations.updateClient(selectedClient);

                    break;

                case 3: System.out.println("\n\n****** MAKE A NEW ORDER ******");
                    Operations.makeNewOrder(selectedClient);

                    break;


                case 4: break;

            }
        } while (menuop != 4);
    }

    public static void deleteClient(ClientDTO client) throws Exception {

        cliDao.delete(client);
        System.out.println("You successfully deleted the client...");

    }

    public static void updateClient(ClientDTO client) throws Exception{

        System.out.println("Insert new name: ");
        String newName = sc.nextLine();
        client.setName(newName);

        System.out.println("Insert new last name: ");
        String newLastName = sc.nextLine();
        client.setLastName(newLastName);

        System.out.println("Insert new description: ");
        String newDescription = sc.nextLine();
        client.setDescription(newDescription);

        int rows = cliDao.update(client);

        System.out.println("You successfully updated client ! "+rows+ " has been modified");



    }

    public static void makeNewOrder(ClientDTO client) throws Exception{

        System.out.println("****WELCOME !******");
        System.out.println("Please select items to add them to the cart...\n");

        ArrayList<Item> items = itDao.getItems();
        ShoppingCartOrder order = new ShoppingCartOrder();

        Item selectedItem = null;


        int menuop = 0;

        do {


            for (int i = 0; i < items.size(); i++) {

                System.out.println("\nID: " + items.get(i).getId());
                System.out.println("Name: " + items.get(i).getName());
                System.out.println("Price: " + items.get(i).getPrice());

            }

            System.out.println("Select Item by ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < items.size(); i++) {

                if (items.get(i).getId() == id) {
                    selectedItem = items.get(i);
                }
            }


            //add item to arraylist of order

            if(selectedItem != null) {

                order.getItemList().add(selectedItem);
                order.setAmount(order.getAmount()+selectedItem.getPrice());

            }

            System.out.println("Do you want to add more items? \n 1.YES\n2.NO");
            int o = sc.nextInt();
            sc.nextLine();

            if(o == 2) {
                menuop = 1;
            }


        }while(menuop!=1);

        int idPayment = PaymentDAO.insertPayment(order.getAmount(),client.getID());

        //add for every item
        for(int i = 0 ; i < items.size() ; i++) {

            OrderDAO.insertPaymentDetails(idPayment,items.get(i).getId());

        }







    }

}
