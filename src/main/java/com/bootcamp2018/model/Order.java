package com.bootcamp2018.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class Order {
    private int Id;
    @Autowired
    private ArrayList<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(int id) {
        Id = id;
    }

    public Order(int id, ArrayList<OrderDetail> orderDetails) {
        Id = id;
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ban = false;
        if (obj != null) {
            if (Order.class.isAssignableFrom(obj.getClass())) {
                final Order other = (Order) obj;
                ban = this.getId() == other.getId();
            }
        }
        return ban;
    }

    @Override
    public String toString() {
        String str = "No Items in the order.";
        if (orderDetails.size() > 0) {
            str = "Order details: ";
            for (int i = 0; i < orderDetails.size(); i++) {
                str += "\n" + i + " " + orderDetails.get(i).toString();
            }
        }
        return str;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        if (orderDetails.size() > 0) {
            boolean ban = false;
            for (OrderDetail od : orderDetails
                    ) {
                if (od.equals(orderDetail)) {
                    od.setQuantity(od.getQuantity() + orderDetail.getQuantity());
                    ban = true;
                }

            }
            if (!ban) {
                orderDetails.add(orderDetail);
            }
        }
    }


}
