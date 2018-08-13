package com.marketplace.bidding.marketplace.Services.Impl;


import com.marketplace.bidding.marketplace.Services.BidService;
import com.marketplace.bidding.marketplace.models.Bid;
import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.repository.BidRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

  @Autowired
  BidRepository BidRepository;


  @Override
  public Bid getById(Long id) throws Exception {
    return BidRepository.findById(id).get();
  }

  @Override
  public Bid addNewBid(Bid bid) throws Exception {
    return BidRepository.save(bid);
  }

  @Override
  public Bid updateBid(Long id, Bid bid) throws Exception {
    if(BidRepository.existsById(id))
      return BidRepository.save(bid);
    throw new RuntimeException("No such Bid exists with Bid id -> "+id);
  }

  @Override
  public Bid deleteBid(Long id) throws Exception {
    if(BidRepository.existsById(id)) {
      Bid u = BidRepository.findById(id).get();
      BidRepository.delete(u);
      return u;
    }
    throw new RuntimeException("No such Auction exists with bid id -> "+id);
  }

  @Override
  public List<Bid> getAllActive() throws Exception {
    List<Bid> bidList = new ArrayList<>();
    BidRepository.findAll().forEach(e -> bidList.add(e));
    return bidList;
  }

  @Override
  public Bid getWinningBid() throws Exception {
      return BidRepository.getWinningBid();
  }


}