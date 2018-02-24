package main.com.java.shoppingcart.entities;

public class Item {
    private Integer id;
    private String name;
    private Integer idOrder;

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(Integer id, String name, Integer idOrder) {
        this.id = id;
        this.name = name;
        this.idOrder = idOrder;
    }

    public Item(String name, Integer idOrder) {
        this.name = name;
        this.idOrder = idOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = id;
    }
}
