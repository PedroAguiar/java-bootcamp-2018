package com.concretepage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DBConfiguration {

    private final DBConnectionProperties dbConnectionProperties;

    @Autowired
    public DBConfiguration(DBConnectionProperties dbConnectionProperties) {
        this.dbConnectionProperties = dbConnectionProperties;
    }

    public void initDB() {
        db.username = dbConnectionProperties.getUsername();
        db.connectionString = dbConnectionProperties.getUrl();
        db.password = dbConnectionProperties.getPassword();
    }

}
