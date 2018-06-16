package com.bootcamp2018;

import com.bootcamp2018.dao.*;

import com.bootcamp2018.model.*;
import com.bootcamp2018.service.ItemService;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] Arg) {
        int op = 0;
        boolean ban = false;
        String menu;
        ItemDAO itemDAO = new ItemDAO();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> listOfItems;
        ItemService is;
        try {
                while (op != 3){
                    System.out.println("Menu");
                    System.out.println("1.Enter as Admin");
                    System.out.println("2.Enter as Client");
                    System.out.println("3.Exit");
                    ban = false;
                    menu = scanner.next();
                    if(isInt(menu)){
                        op = Integer.parseInt(menu);
                        switch (op){
                            case 1:
                                op = 0;
                                while (op != 5){
                                    System.out.println("Admin Menu");
                                    System.out.println("1.Item Menu");
                                    System.out.println("2.Discount Menu");
                                    System.out.println("3.Payment Menu");
                                    System.out.println("4.Clients Menu");
                                    System.out.println("5.Exit");
                                    menu= scanner.next();
                                    if(isInt(menu)){
                                        op = Integer.parseInt(menu);
                                        switch (op){
                                            case 1:
                                                op = 0;
                                                while (op != 5) {
                                                    System.out.println("Item Menu");
                                                    System.out.println("1.Create Item");
                                                    System.out.println("2.Retrieve Items");
                                                    System.out.println("3.Update Item");
                                                    System.out.println("4.Delete Item");
                                                    System.out.println("5.Exit");
                                                    menu = scanner.next();
                                                    if (isInt(menu)) {
                                                        op = Integer.parseInt(menu);
                                                        switch (op){
                                                            case 1:
                                                                while (!ban){
                                                                    System.out.println("Enter item name: ");
                                                                    String name = scanner.next();
                                                                    if (name != null){
                                                                        while (!ban){
                                                                            System.out.println("Enter item price: ");
                                                                            String prices = scanner.next();
                                                                            if (isDouble(prices)){
                                                                                double price = Double.parseDouble(prices);
                                                                                is = new ItemService();
                                                                                Item created = is.create(new Item(name,price));
                                                                                if (created == null) {
                                                                                    System.out.println("Error");
                                                                                }
                                                                                ban= true;

                                                                            }else{
                                                                                System.out.println("Please enter a valid value.");
                                                                            }
                                                                        }
                                                                    }else{
                                                                        System.out.println("Please enter a valid value.");
                                                                    }
                                                                }
                                                                break;
                                                            case 2:
                                                                    System.out.println("List of Items: ");
                                                                    is = new ItemService();
                                                                    listOfItems = is.getList(new Item());
                                                                    for (Item i: listOfItems
                                                                         ) {
                                                                        System.out.println(i.toString());
                                                                    }
                                                                    scanner.next();
                                                                break;
                                                            case 3:
                                                                ban = false;
                                                                while (!ban) {
                                                                    System.out.println("List of Items: ");
                                                                    listOfItems = itemDAO.retriveItems(new Item());
                                                                    for (Item i : listOfItems
                                                                            ) {
                                                                        System.out.println(i.toString());
                                                                    }
                                                                    System.out.println("Enter Item Code to modify: ");
                                                                    String code = scanner.next();
                                                                    if (isInt(code) && listOfItems.contains(new Item(Integer.parseInt(code),"",0))) {
                                                                        while (!ban){
                                                                            Item updateItem = listOfItems.get(listOfItems.indexOf(new Item(Integer.parseInt(code),"",0)));
                                                                            System.out.println("Item current name is: "+updateItem.getName()+", enter new name: ");
                                                                            String name = scanner.next();
                                                                            if (name != null){
                                                                                updateItem.setName(name);
                                                                                while (!ban){
                                                                                    System.out.println("Enter item price: ");
                                                                                    String prices = scanner.next();
                                                                                    if (isDouble(prices)){

                                                                                        updateItem.setPrice(Double.parseDouble(prices));
                                                                                        is = new ItemService();
                                                                                        is.update(updateItem);

                                                                                        if (!ban) {
                                                                                            System.out.println("Error");
                                                                                            ban= true;
                                                                                        }
                                                                                    }else{
                                                                                        System.out.println("Please enter a valid value.");
                                                                                    }
                                                                                }
                                                                            }else{
                                                                                System.out.println("Please enter a valid value.");
                                                                            }

                                                                        }
                                                                    }
                                                                }
                                                                break;
                                                            case 4:
                                                                break;
                                                            case 5:
                                                                break;
                                                            default:
                                                                System.out.println("Number must be between 1 and 5");
                                                                break;

                                                        }
                                                    }
                                                }
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                break;
                                            case 5:
                                                break;
                                            default:
                                                System.out.println("Number must be between 1 and 5");
                                                break;
                                        }
                                    }
                            }
                            break;
                            case 2:

                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Number must be between 1 and 3 ");
                                break;
                        }

                    }


                }

        }catch (Exception e){

        }


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
