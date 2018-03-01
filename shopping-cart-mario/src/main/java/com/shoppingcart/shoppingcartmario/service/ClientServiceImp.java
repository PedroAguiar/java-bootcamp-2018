package com.shoppingcart.shoppingcartmario.service;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    //    @Autowired
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public synchronized boolean addClient(Client client) {
        if (clientRepository.clientExists(client.getFirstName(), client.getLastName(), client.getDescription())) {
            return false;
        } else {
            clientRepository.addClient(client);
            return true;
        }
    }

    @Override
    public Client getClientById(int idClient) {
        Client obj = clientRepository.getClientById(idClient);
        return obj;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.updateClient(client);
    }

    @Override
    public void deleteClient(int idClient) {
        clientRepository.deleteClient(idClient);
    }
}
