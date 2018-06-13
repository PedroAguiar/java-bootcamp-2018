package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.model.Item;

import java.sql.*;
import java.util.ArrayList;


public class ItemDAO {



    public boolean createItem(Item item) {


        boolean ban = true;
        try(Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO item (Name,Price) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, item.getName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            } else {
                ban = false;
            }
            pstmt.close();
        } catch (Exception e){
            ban = false;
        }

        return ban;
    }
    public ArrayList<Item>  retriveItems() throws SQLException {
        ArrayList<Item> list = new ArrayList<>();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()){
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idItem, name, price FROM item");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }


        } catch (Exception e) {

        }

        return list;

    }
    public boolean deleteItem(Item item) throws SQLException {
        boolean ban = true;
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("DELETE FROM item WHERE idItem = ?");
            pstmt.setInt(1, item.getId());
            int resp = pstmt.executeUpdate();
            if (resp == 0) ban = false;

        } catch (Exception e) {
            ban = false;
        }
        return ban;
    }
    public boolean updateItem(Item item) throws SQLException {
        boolean ban = true;
        try(Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("UPDATE item SET name = ?, price= ? WHERE idItem= ?");
            pstmt.setString(1, item.getName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setInt(3, item.getId());

            int resp = pstmt.executeUpdate();
            if (resp == 0) ban = false;

        } catch (Exception e) {
            ban = false;
        }
        return ban;
    }
// CRear clase que con ReturnSet me de el objeto que yo toque o la lista de objetos que yo toque;
}
