package com.shoppingcart.shoppingcartmario.service;

import com.shoppingcart.shoppingcartmario.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(int idClient);
    boolean addClient(Client client);
    void updateClient(Client client);
    void deleteClient(int idClient);
}
