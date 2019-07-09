package com.sashutosh.microservice.ordering.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer,String> {
}
