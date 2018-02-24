package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;




public class Access {


    java.sql.Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=javaProject;integratedSecurity=true;");
    //private static Connection conn;

    public Access() throws SQLException {

    }

    //Add new client to the db
    public void addNewClient(String name, String lastname, String desc, int deleted) throws SQLException {
        try {
            long nextId = getNextId();
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Clients " + "VALUES (" + nextId + ", '" + name + "','" + lastname + "','" + desc + "', "+deleted+")";
            stmt.executeUpdate(query);
            System.out.println("The client was added correctly!!");
        } catch (SQLException ex) {
            System.out.println(getNextId());
            System.out.println("There was a problem adding a new client..");
        }

    }

    //Delete client from db
    public void deleteClient(long id) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "UPDATE Clients SET deleted = 1 WHERE id = "+id;
        stmt.executeUpdate(query);
    }

    //Update client method
    public void updateClient(long id, String name, String lastname, String desc, int deleted) throws SQLException {
        try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE Clients SET name = '"+name+"', lastName = '"+lastname+"',description = '"+desc+"', deleted = "+deleted+" WHERE id = "+id);
                System.out.println("The client was updated correctly!!");
            }
            catch (SQLException ex) {
                System.out.println("There was an error updating the client..");
            }
    }

    //Validating the client
    public boolean validateClient(long id) throws SQLException {
        boolean exists = false;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id FROM Clients");
        while (rs.next()) {
            if (rs.getLong("id") == id) {
                exists = true;
                System.out.println("Client found!");
            }
        }
        return exists;
    }

    ///Show all clients with their respective data
    public void getAllClients() throws SQLException {

        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM Clients";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            String name= rs.getString("name");
            String lastname = rs.getString("lastName");
            long id = rs.getLong("id");
            String deleted = "NO";
            if( rs.getInt("deleted") == 1){
                deleted = "YES";
            }
            System.out.println("Client id: "+id+", Name: "+name+ ", Last Name: " + lastname+" , Deleted: "+deleted+"\t");
        }
    }

    //Generate correlative id
    public long getNextId() throws SQLException {
        long nextId = 1;
        Statement stmt = conn.createStatement();
        String query = "SELECT id FROM Clients";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            if( rs.getLong("id") >= nextId ){
                nextId = rs.getLong("id");
            }
        }
        if(rs.next() == false || nextId == rs.getLong("id")){
            nextId += 1;
        }
        return nextId;
    }

    //Create new Order
    public void newOrder(List items, float amount, long selected_id) throws SQLException {

        //Payment payment = new Payment(getNextPaymentId(), amount);
        //Order ord = new Order(getNextOrderId(), items, payment);
        long nextOrderId = getNextOrderId();
        Statement stmt = conn.createStatement();
        String query = "INSERT INTO Payments " + "VALUES ("+nextOrderId+", "+amount+", 0)";
        stmt.executeUpdate(query);
        query = "INSERT INTO Orders " + "VALUES ("+nextOrderId+", "+getNextPaymentId()+", 0 ,"+selected_id+")";
        stmt.executeUpdate(query);
        //Adding items to the order
        for(int i=0; i < items.size(); i++){
            long nextItem = getNextItemId();
            String itemName = items.get(i).toString();
            query = "INSERT INTO Items " + "VALUES ("+nextItem+", '"+itemName+"',"+nextOrderId+")";
            stmt.executeUpdate(query);
        }



    }

    public String showAllOrders() throws SQLException
    {
        //PReguntar como hacerlo, 2 RS al mismo tiempo no se puede
        String allOrdersString = "";
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM Orders O JOIN Items I ON O.id_order = I.id_order WHERE O.id_order = I.id_order";
        ResultSet rs = stmt.executeQuery(query);
        StringBuffer itemsXorder = new StringBuffer();
        itemsXorder.append("ITEMS: ");
        while (rs.next()) {
            int id_order = rs.getInt("id_order");
            int id_client = rs.getInt("id_client");
            int id_payment = rs.getInt("id_payment");
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Orders O JOIN Items I ON O.id_order = I.id_order WHERE O.id_order = " + id_order);
                while (rs2.next()) {
                    String item = rs.getString("name");
                    itemsXorder.append(item + " - ");
                }
                System.out.println("Client id: " + id_client + ", Order id: " + id_order + ", Payment id: " + id_payment + "\t");
                System.out.println(itemsXorder);
            }


        return allOrdersString;
    }



    //Generate order correlative id
    public long getNextOrderId() throws SQLException {
        long nextId = 0;
        Statement stmt = conn.createStatement();
        String query = "SELECT id_order FROM Orders";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            if( rs.getLong("id_order") >= nextId ){
                nextId = rs.getLong("id_order");
            }
        }
        if(rs.next() == false || nextId == rs.getLong("id_order")){
            nextId += 1;
        }
        return nextId;
    }

    //Generate item correlative id
    public long getNextItemId() throws SQLException {
        long nextId = 0;
        Statement stmt = conn.createStatement();
        String query = "SELECT id_item FROM Items";
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            if( rs.getLong("id_item") >= nextId ){
                nextId = rs.getLong("id_item");
            }
        }
        if(rs.next() == false || nextId == rs.getLong("id_item")){
            nextId += 1;
        }
        return nextId;
    }



    //Generate payment correlative id
    public long getNextPaymentId() throws SQLException {
        long nextId = 0;
        Statement stmt = conn.createStatement();
        String query = "SELECT id_payment FROM Orders WHERE id_order = "+getNextOrderId();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            if( rs.getLong("id_payment") >= nextId ){
                nextId = rs.getLong("id_payment");
            }
        }
        if(rs.next() == false || nextId == rs.getLong("id_payment")){
            nextId += 1;
        }
        return nextId;
    }


}
