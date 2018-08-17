package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, Long> {
  Buyer findBuyerByEmailAndPassword(String email, String password);
}