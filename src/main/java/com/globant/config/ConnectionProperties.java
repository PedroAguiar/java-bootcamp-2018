package com.globant.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConnectionProperties {

    private static final String DATABASE_URL_PROPERTY_KEY = "database.url";
    private static final String DATABASE_USERNAME_PROPERTY_KEY = "database.username";
    private static final String DATABASE_PASSWORD_PROPERTY_KEY = "database.password";
    private static ConnectionProperties instance;
    private Properties properties = new Properties();

    private ConnectionProperties() {

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            properties.load(loader.getResourceAsStream("application.properties"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find application properties file");
        } catch (IOException e) {
            System.out.println("Error trying to read application properties");
        }

        // get the property value and print it out
        System.out.println("Successfully loaded database url= " + properties.getProperty(DATABASE_URL_PROPERTY_KEY));
        System.out.println("Successfully loaded database username= " + properties.getProperty(DATABASE_USERNAME_PROPERTY_KEY));
        System.out.println("Successfully loaded database password= " + properties.getProperty(DATABASE_PASSWORD_PROPERTY_KEY));
    }

    public static ConnectionProperties getInstance() {
        return instance == null ? new ConnectionProperties() : instance;
    }

    public String getDatabaseUrl() {
        return properties.getProperty(DATABASE_URL_PROPERTY_KEY);
    }

    public String getDatabaseUserName() {
        return properties.getProperty(DATABASE_USERNAME_PROPERTY_KEY);
    }

    public String getDatabasePassword() {
        return properties.getProperty(DATABASE_PASSWORD_PROPERTY_KEY);
    }

    public Properties getProperties() {
        return properties;
    }
}
