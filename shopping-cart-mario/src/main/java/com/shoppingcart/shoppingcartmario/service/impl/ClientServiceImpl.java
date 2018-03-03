package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.model.Payment;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.service.ClientService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
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
        Validate.isTrue(clientExists(client.getId()));
        clientRepository.update(client.getFirstName(), client.getLastName(), client.getDescription(), client.getId());
    }

    @Override
    public void deleteClient(Integer idClient) {
        clientRepository.deleteById(idClient);
    }

//    @Override
//    public List<Payment> getAllPayments(Integer clientId) {
//        Client client = clientRepository.findById(clientId).get();
//        List<Payment> payments = client.getPayments();
//        return payments;
//    }


    private boolean clientExists(String firstName, String lastName, String description) {
        return clientRepository.findByFirstNameAndLastNameAndDescription(firstName, lastName, description) != null;
    }

    private boolean clientExists(Integer clientId) {
        return clientRepository.findById(clientId).isPresent();
    }
}
