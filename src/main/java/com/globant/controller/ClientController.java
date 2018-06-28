package com.globant.controller;

import com.globant.dto.ClientDTO;
import com.globant.service.ClientService;
import com.globant.service.CRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClientController {

    private final CRUD<ClientDTO> clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO create(ClientDTO clientDTO) {
        validate(clientDTO);
        return clientService.create(clientDTO);
    }

    @RequestMapping(value = "/retrieveClient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO read(int clientId) {
        return clientService.read(clientId);
    }

    @RequestMapping(value = "/updateClient", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
        public ClientDTO update(ClientDTO clientDTO) {
        validate(clientDTO);
        return clientService.update(clientDTO);
    }

    @RequestMapping(value = "/deleteClient", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(int clientId) {
        clientService.delete(clientId);
    }

    @RequestMapping(value = "/retrieveClient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDTO> readAll(List<Integer> clientIds) {
        return clientService.readAll();
    }

    private void validate(ClientDTO clientDTO) {
        if (clientDTO == null)
            throw new IllegalArgumentException("object cannot be null");
    }
}
