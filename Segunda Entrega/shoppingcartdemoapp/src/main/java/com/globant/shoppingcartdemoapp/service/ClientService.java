package com.globant.shoppingcartdemoapp.service;
import com.globant.shoppingcartdemoapp.entities.*;
import java.util.*;

import com.globant.shoppingcartdemoapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll()
                .forEach(clients::add);

        return clients;
    }

    public Client getClient(int id) {
        return clientRepository.findById(id);
    }


    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(int id){
        clientRepository.deleteById(id);
    }
}
