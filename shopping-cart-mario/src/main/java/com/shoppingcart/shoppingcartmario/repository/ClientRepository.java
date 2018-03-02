package com.shoppingcart.shoppingcartmario.repository;

import com.shoppingcart.shoppingcartmario.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//This is how Spring Data works you just need to extend JpaRepository interface and it will provide
//out-of-the box functionalities like the ones you had implemented
public interface ClientRepository extends JpaRepository<Client, Integer> {


    Client findByFirstNameAndLastNameAndDescription(String firstName, String lastName, String description);

    @Modifying
    @Query("UPDATE Client SET firstName = :firstName, lastName = :lastName, description = :description WHERE id = :clientId")
    void update(@Param("firstName") String firstName, @Param("lastName")String lastName,
                @Param("description")String description, @Param("clientId") Integer clientId);

}
