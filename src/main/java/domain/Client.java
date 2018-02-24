package domain;

import java.util.List;

public class Client {
    private int id;
    private String name, lastName;
    private String description;
    private int deleted;


    //Constructor sin parametros
    public Client()
    {
    }

    //Constructor
    public Client( int id_c, String n, String ls, String desc, int del ) {
        id = id_c;
        name = n;
        lastName = ls;
        description = desc;
        if (del != 0 && del != 1) {
            deleted = 0;
        } else {
            deleted = del;
        }
    }


    @Override
    public String toString()
    {
        return name + lastName;
    }

}
