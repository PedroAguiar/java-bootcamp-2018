package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.service.ClientService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        Validate.isTrue(!clientExists(client.getFirstName(), client.getLastName(), client.getDescription()));
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(Integer clientId) {
        Validate.isTrue(clientExists(clientId));
        return clientRepository.getOne(clientId);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    //We need this to be transactional because of the @Modifying query
    @Transactional
    public void updateClient(Client client) {
        Validate.isTrue(clientExists(client.getClientId()));
        clientRepository.update(client.getFirstName(), client.getLastName(), client.getDescription(), client.getClientId());
    }

    @Override
    public void deleteClient(Integer idClient) {
        clientRepository.deleteById(idClient);
    }


    private boolean clientExists(String firstName, String lastName, String description) {
        return clientRepository.findByFirstNameAndLastNameAndDescription(firstName, lastName, description) != null;
    }

    private boolean clientExists(Integer clientId) {
        return clientRepository.findById(clientId).isPresent();
    }
}
