package com.globant.shoppingcartdemoapp.controller;
import com.globant.shoppingcartdemoapp.service.ClientService;
import com.globant.shoppingcartdemoapp.entities.Client;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    private ClientController(ClientService clientService){
        this.clientService = clientService;
    }


    @RequestMapping(value="/client",method= RequestMethod.POST)
    public void addClient(@RequestBody Client client) {

        clientService.addClient(client);

    }

    @RequestMapping(value="/client/{id}",method= RequestMethod.GET)
    public Client getClient(@PathVariable int id) {

        return clientService.getClient(id);

    }

    @RequestMapping(value="/clients",method= RequestMethod.GET)
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value="/client", method = RequestMethod.PUT)
    public void updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }

    @RequestMapping(value="/client/{id}",method=RequestMethod.DELETE)
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }






}
