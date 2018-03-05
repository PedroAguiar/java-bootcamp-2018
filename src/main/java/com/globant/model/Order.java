package com.globant.model;

public class Order {
    private int id;
    private String name;
    private int idClient;

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    public Order(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Order(String name, int idClient) {
        this.name = name;
        this.idClient = idClient;
    }

    public Order(int id, String name, int idClient) {
        this.id = id;
        this.name = name;
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient= idClient;
    }
}
