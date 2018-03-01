package com.shoppingcart.shoppingcartmario.controller;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
        Client client = clientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> list = clientService.getAllClients();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<Void> addClient(@RequestBody Client client, UriComponentsBuilder builder) {
        System.out.println("client/// --> " + client.toString());
        boolean flag = clientService.addClient(client);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/client/{id}").buildAndExpand(client.getIdClient()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/client")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
