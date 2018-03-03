package com.app;
import java.util.*;
import com.controller.Operations;



/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);


        int menuop = 0;

        do {

            System.out.println("---------- > Welcome to ShoppingCart App !");
            System.out.println("1-Add Client");
            System.out.println("2-Select Client");
            System.out.println("3-Exit");

            menuop = sc.nextInt();
            sc.nextLine();

            switch (menuop) {

                case 1:
                    System.out.println("\n\n****** ADD CLIENT ******");
                    Operations.addClient();


                    break;
                case 2:
                    System.out.println("\n\n****** SELECT CLIENT ******");
                    Operations.selectClient();

                    break;

                case 3:
                    System.exit(0);

                    break;


            }
        } while (menuop != 3);
        System.out.println("Thanks for using ShoppingCart App!");

    }


}




















        /*
        float floatVar = (float) 2.5;
        int intVar = 15;
        String stringVar = "ELMO";



        String fs;
        fs = String.format("The value of the float " +
                        "variable is %g, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        " and the string is %s",
                floatVar, intVar, stringVar);

        System.out.println(fs);

        String url = "jdbc:mysql://localhost:3306/dbprueba?useSSL=false";
        String uname = "root";
        String pass = "admin";
        String query = "select * from persona";

        Class.forName("com.mysql.jdbc.Driver");

        Connection con =  DriverManager.getConnection(url,uname,pass);

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {
            System.out.println("ID: " + rs.getInt(1) + "- Nombre: " + rs.getString(2) + "- Apellido: " + rs.getString(3));
        }

        rs.close();
        st.close();
        con.close();*/



