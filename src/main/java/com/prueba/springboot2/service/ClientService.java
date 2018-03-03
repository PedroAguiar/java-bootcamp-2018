package com.prueba.springboot2.service;
import java.util.List;

import com.prueba.springboot2.entity.Client;
import com.prueba.springboot2.dao.IClientDAO;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientDAO clientDAO;
    @Override
    public Client getClientById(long clientId) {
        Client obj = clientDAO.getClientById(clientId);
        return obj;
    }
    @Override
    public List<Client> getAllClients(){
        return clientDAO.getAllClients();
    }
    @Override
    public synchronized boolean addClient(Client client){
        if (clientDAO.clientExists(client.getClientName(), client.getClientLastName())) {
            return false;
        } else {
            clientDAO.addClient(client);
            return true;
        }
    }
    @Override
    public void updateClient(Client client) {
        clientDAO.updateClient(client);
    }
    @Override
    public void deleteClient(long clientId) {
        clientDAO.deleteClient(clientId);
    }
}