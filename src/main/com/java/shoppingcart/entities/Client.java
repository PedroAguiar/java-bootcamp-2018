package main.com.java.shoppingcart.entities;

public class Client {
    private Integer id;
    private String name;
    private String lastname;
    private String description;

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, String name, String lastname, String description) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.description = description;
    }

    public Client(Integer id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public Client(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Client(String name, String lastname, String description) {
        this.name = name;
        this.lastname = lastname;
        this.description = description;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
