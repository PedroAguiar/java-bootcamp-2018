package com.shoppingcart.entity;

public class Order {
    private Integer id;
    private String name;
    private Integer idClient;

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Order(String name, Integer idClient) {
        this.name = name;
        this.idClient = idClient;
    }

    public Order(Integer id, String name, Integer idClient) {
        this.id = id;
        this.name = name;
        this.idClient = idClient;
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

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer id) {
        this.idClient = id;
    }
}
