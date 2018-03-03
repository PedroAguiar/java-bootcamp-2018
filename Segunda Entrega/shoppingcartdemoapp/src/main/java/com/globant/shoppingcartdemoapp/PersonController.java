package com.globant.shoppingcartdemoapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping("/hello")
    public String sayHi() {
        return "HELLO WORLD";
    }
}
