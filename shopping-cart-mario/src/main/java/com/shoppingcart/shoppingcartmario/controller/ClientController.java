package com.shoppingcart.shoppingcartmario.controller;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.service.ClientService;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@Slf4j This does exactly what line #22 does
@RestController
public class ClientController {

    //This creates a Logger Object
    // that will be taking care of doing what you did with 'System.out.prinln statements' a.k.a 'logging'
    private Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //@RequestMapping(value = "/client")
    @GetMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
        System.out.println("id  ------->>> "+id);
        Client client = clientService.getClient(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> list = clientService.getAllClients();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> addClient(@RequestBody Client client) {

        //Logging example, the value of '{}' gets filled with the output of client.toString()
        LOGGER.info("Adding client {} ", client.toString());
//
//        System.out.println("client/// --> " + client.toString());

        final Client persistedClient = clientService.createClient(client);
        Validate.notNull(persistedClient);

        return new ResponseEntity<>(persistedClient, HttpStatus.CREATED);
    }

    @PutMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    @GetMapping(value = "/client/{id}/Payments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
//        System.out.println("id  ------->>> "+id);
//        Client client = clientService.getClient(id);
//        return new ResponseEntity<>(client, HttpStatus.OK);
//    }

}
