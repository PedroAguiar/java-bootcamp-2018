package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import service.ClientService;
import service.ItemService;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

}

