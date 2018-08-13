package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.Bid;
import com.marketplace.bidding.marketplace.models.Project;
import java.net.PortUnreachableException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface BidRepository extends CrudRepository<Bid,Long>{

  @Query(value = "SELECT bid.project_id,min(bid.amount) from bid,project where project.id = bid.project_id and project.bidding_end_time >= now()  group by bid.project_id", nativeQuery = true)
  Bid getWinningBid() throws Exception;

}