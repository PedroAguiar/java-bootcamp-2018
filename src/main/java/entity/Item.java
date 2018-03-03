package entity;

import javax.persistence.*;


@Table(name="Items")
@Entity

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item")
    private int id_item;
    @Column(name = "name")
    private String name;
    @Column(name = "id_order")
    private int id_order;

    public Item(){

    }
    public Item(String name, int id_order) {
        this.name = name;
        this.id_order = id_order;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }
}
