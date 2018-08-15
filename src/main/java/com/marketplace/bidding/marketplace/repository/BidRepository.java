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

  @Query(value = "SELECT * FROM BID WHERE AMOUNT = (select min(amount) from bid, project where project.id=bid.project_id and project.bidding_end_time >= now())", nativeQuery = true)
  List<Bid> getWinningBid();

  @Query(value = "SELECT * FROM BID WHERE buyer_user_id AMOUNT = (select min(amount) from bid, project where project.id=bid.project_id and project.bidding_end_time >= now()) buyer_user_id=?1", nativeQuery = true)
  List<Bid> getWinningBidForBuyerId(Long buyerUserId);

  List<Bid> findBidsByProject_Seller_Id(Long sellerId);

  List<Bid> findBidsByBuyer_Id(Long buyerId);

}