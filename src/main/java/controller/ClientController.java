package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import service.ClientService;



@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

}


