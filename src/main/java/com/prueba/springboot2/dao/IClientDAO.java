package com.prueba.springboot2.dao;

import java.util.List;
import com.prueba.springboot2.entity.Client;

public interface IClientDAO {
    List<Client> getAllClients();
    Client getClientById(long id);
    void addClient(Client client);
    void updateClient(Client client);
    void deleteClient(long clientId);
    boolean clientExists(String name, String lastName);
}