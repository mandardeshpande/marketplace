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

  Bid getWinningBid() throws Exception;
}
