package com.prueba.JavaApp;

import controller.Controller;
import java.sql.SQLException;
import java.util.Scanner;


public class javaApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        {
            Scanner scan = new Scanner(System.in);
            Controller controller = new Controller();
            int op;
            do {
                System.out.println("1. Clients Menu");
                System.out.println("2. Orders Menu");
                System.out.println("3. Items Menu");
                System.out.println("4. Exit!");
                System.out.println("Choose option: ");
                op = scan.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("..CLIENT..");
                        controller.clientMenu();
                    break;

                    case 2:
                        System.out.println("..ORDERS MENU..");
                        controller.orderMenu();
                    break;

                    case 3:
                        System.out.println("..ITEMS MENU..");
                    break;

                    case 4:
                        System.exit(0);
                    break;
                }

            }
            while( op != 4);
        }

    }
}
