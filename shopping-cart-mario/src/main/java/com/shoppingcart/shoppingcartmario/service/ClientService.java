package com.shoppingcart.shoppingcartmario.service;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Payment;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClient(Integer clientId);
    Client createClient(Client client);
    void updateClient(Client client);
    void deleteClient(Integer idClient);
//    List<Payment>getAllPayments(Integer clientId);
}
