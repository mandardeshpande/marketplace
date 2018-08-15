package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.Bid;
import com.marketplace.bidding.marketplace.models.Project;
import java.net.PortUnreachableException;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface BidRepository extends CrudRepository<Bid,Long>{

  @Query(value = "SELECT Bid.project_id,min(Bid.amount) from Bid,Project where Project.Id = Bid.project_id and Project.bidding_end_time >= now()  group by Bid.project_id", nativeQuery = true)
  List<Bid> getWinningBid();

  List<Bid> findBidsByProject_Seller_Id(Long sellerId);

  List<Bid> findBidsByBuyer_Id(Long buyerId);

}