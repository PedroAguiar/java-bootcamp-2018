package com.shoppingcart.shoppingcartmario.repository;

import com.shoppingcart.shoppingcartmario.model.Client;

import java.util.List;

public interface ClientRepository {

    List<Client> getAllClients();

    Client getClientById(int idClient);

    void addClient(Client client);

    void updateClient(Client client);

    void deleteClient(int idClient);

    boolean clientExists(String firstName, String lastName, String description);
}
