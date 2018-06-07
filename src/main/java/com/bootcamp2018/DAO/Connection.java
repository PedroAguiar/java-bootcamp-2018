package com.bootcamp2018.DAO;

public class Connection {
    private static Connection ourInstance = new Connection();

    public static Connection getInstance() {
        return ourInstance;
    }

    private Connection() {
    }
}
