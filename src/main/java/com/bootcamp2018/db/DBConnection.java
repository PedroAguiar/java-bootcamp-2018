package com.bootcamp2018.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.graalvm.compiler.serviceprovider.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBConnection {
    @Autowired
    private static DBConnection ourInstance = null;
    @Autowired
    private static MysqlDataSource ds = new MysqlDataSource();

    public static DBConnection getInstance() {
        if (ourInstance == null) {
            ourInstance = new DBConnection();
        }
        return ourInstance;
    }

    private DBConnection() {
        try {
            ds = new MysqlDataSource();
            ds.setServerName("localhost");
            ds.setDatabaseName("boot2018");
            ds.setPortNumber(3306);
            ds.setUser("root");
            ds.setPassword("Meteora218!");

        } catch (Exception e) {
            System.out.println("fail");
        }
    }


    public static MysqlDataSource getDataSource() {
        return ds;
    }
}
