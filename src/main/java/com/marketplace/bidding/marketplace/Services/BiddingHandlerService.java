package com.marketplace.bidding.marketplace.Services;

import com.marketplace.bidding.marketplace.models.BidInformation;
import com.marketplace.bidding.marketplace.models.Bid;
import java.util.List;
import javax.xml.ws.Response;

public interface BiddingHandlerService {

  //Response<?> joinAuction(String productId,AuctionJoinRequestDto auctionJoinRequest)throws Exception;

  //Response<?> addBid(String productId,AuctionBidRequestDto auctionBidRequest)throws Exception;

  List<Bid> getAllAuctions()throws Exception;

  BidInformation getAuctionWinner(String productId)throws Exception;

  Response<?> getAuctionDetails(String productId)throws Exception;

  void markAuctionAsCompleted(String productId)throws Exception;
}
