package com.marketplace.bidding.marketplace.Services;

import com.marketplace.bidding.marketplace.models.BidInformation;

public interface BidInformationService {

  public BidInformation addBidInformationForWinningBid(BidInformation bidInformation) throws Exception;
}
