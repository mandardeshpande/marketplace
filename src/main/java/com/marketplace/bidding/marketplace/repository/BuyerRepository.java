package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.Buyer;
import com.marketplace.bidding.marketplace.models.User;
import org.springframework.data.repository.CrudRepository;

public interface BuyerRepository extends CrudRepository<Buyer, Long> {
  Buyer findByBuyerUser_Id(Long buyerId);
}