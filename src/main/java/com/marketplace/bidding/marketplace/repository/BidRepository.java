package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.Bid;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface BidRepository extends CrudRepository<Bid,Long>{

}