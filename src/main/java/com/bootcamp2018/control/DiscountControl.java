package com.bootcamp2018.control;

import com.bootcamp2018.dao.DiscountDAO;
import com.bootcamp2018.model.Discount;

import java.util.ArrayList;

public class DiscountControl {

    public Discount create(Discount object) {
        DiscountDAO dDAO = new DiscountDAO();
        return dDAO.createDiscount(object);
    }


    public Discount get(Discount object) {
        return null;
    }


    public ArrayList<Discount> getList(Discount object) {
        return null;
    }


    public Discount update(Discount object) {
        return null;
    }


    public void delete(Discount object) {

    }
}
