package com.shoppingcart.shoppingcartmario.repository;

import com.shoppingcart.shoppingcartmario.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//See how I provided the Type of the repository 'Item' and the type of it's id
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Item findByName(String name);

    @Modifying
    @Query("UPDATE Item SET name = :name WHERE id = :itemId")
    void update(@Param("name") String name, @Param("itemId") Integer itemId);
}