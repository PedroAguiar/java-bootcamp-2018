package com.globant.shoppingcartdemoapp.repository;
import com.globant.shoppingcartdemoapp.entities.*;
import org.springframework.data.repository.CrudRepository;

import java.util.*;


public interface ClientRepository extends CrudRepository<Client,Integer> {

    Client findById(int clientId);

}
