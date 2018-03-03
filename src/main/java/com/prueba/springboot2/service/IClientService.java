package com.prueba.springboot2.service;

import java.util.List;
import com.prueba.springboot2.entity.Client;
public interface IClientService {
    List<Client> getAllClients();
    Client getClientById(long clientId);
    boolean addClient(Client client);
    void updateClient(Client client);
    void deleteClient(long clientId);

}


