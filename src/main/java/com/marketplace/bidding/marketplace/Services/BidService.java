package com.marketplace.bidding.marketplace.Services;

import com.marketplace.bidding.marketplace.models.Bid;
import com.marketplace.bidding.marketplace.models.Project;
import java.util.List;

public interface BidService {

  Bid getById(Long id)throws Exception;

  List<Bid> getAllActive() throws Exception;

  Bid addNewBid(Bid bid)throws Exception;

  Bid updateBid(Long id, Bid auction)throws Exception;

  Bid deleteBid(Long id)throws Exception;

  List<Bid> getWinningProjectByLowBidAmount() throws Exception;

  List<Bid> getWinningProjectLowestAmountAndBuyerId(Long buyerId) throws Exception;

  List<Bid> getAllBidsForProjectId(Long projectSellerId) throws Exception;

  List<Bid> getAllBidsByBuyerId(Long buyerId) throws Exception;


}
