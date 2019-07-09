package com.sashutosh.microservice.ordering.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query("Select * from CardTypes")
    List<CardType> getCardTypes();
}
