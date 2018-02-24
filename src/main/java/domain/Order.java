package domain;

import java.util.List;

public class Order {
    private long id;
    private List items;
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order(long id, List items, Payment payment) {
        this.id = id;
        this.items = items;
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
