package com.bootcamp2018.Model;

public class Item implements Comparable<Item>{
    private int Id;
    private String name;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int compareTo(Item o) {
        return this.getId() - o.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Item.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Item other = (Item) obj;

        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "Id: "+getId()+ ", Name: "+getName();
    }
}
