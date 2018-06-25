package com.bootcamp2018.service;

import com.bootcamp2018.dao.DiscountDAO;
import com.bootcamp2018.model.Discount;

import java.util.ArrayList;

public class DiscountService implements Service<Discount> {
    @Override
    public Discount create(Discount object) {
        DiscountDAO dDAO = new DiscountDAO();
        return dDAO.createDiscount(object);
    }

    @Override
    public Discount get(Discount object) {
        return null;
    }

    @Override
    public ArrayList<Discount> getList(Discount object) {
        return null;
    }

    @Override
    public Discount update(Discount object) {
        return null;
    }

    @Override
    public void delete(Discount object) {

    }
}
