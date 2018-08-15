package com.marketplace.bidding.marketplace.Services.Impl;

import com.marketplace.bidding.marketplace.Services.BidInformationService;
import com.marketplace.bidding.marketplace.models.BidInformation;
import com.marketplace.bidding.marketplace.repository.BidInformationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidInformationServiceImpl implements BidInformationService {

  @Autowired
  BidInformationRespository bidInformationRespository;


  @Override
  public BidInformation addBidInformationForWinningBid(BidInformation bidInformationData) {
    BidInformation bidInformation = bidInformationRespository.save(bidInformationData);
    return bidInformation;
  }
}
