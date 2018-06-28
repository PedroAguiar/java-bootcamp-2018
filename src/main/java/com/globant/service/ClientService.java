package com.globant.service;

import com.globant.dao.ClientDAO;
import com.globant.dao.DataAccessObject;
import com.globant.dto.ClientDTO;
import com.globant.model.Client;
import com.globant.util.DTOUtils;
import com.globant.util.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService implements CRUD<ClientDTO> {

    private final DataAccessObject<Client> clientDAO;

    @Autowired
    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public ClientDTO create(ClientDTO clientDTO) {
        Client client = clientDAO.create(ModelUtils.toClient(clientDTO));
        return DTOUtils.clientDTO(client);
    }

    public ClientDTO read( int id ) {
        return null;
    }

    public ClientDTO update( ClientDTO object ) {
        return null;
    }

    public void delete( int id ) {

    }

    public List<ClientDTO> readAll() {
        return null;
    }
}
