package com.marketplace.bidding.marketplace.Services.Impl;

import com.marketplace.bidding.marketplace.Services.BuyerService;
import com.marketplace.bidding.marketplace.models.Buyer;
import com.marketplace.bidding.marketplace.repository.BuyerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

  @Autowired
  BuyerRepository buyerRepository;

  @Override
  public Buyer getById(Long id) throws Exception {
    return buyerRepository.findById(id).get();
  }

  @Override
  public Buyer registerBuyer(Buyer buyer) throws Exception {
    return buyerRepository.save(buyer);
  }

  @Override
  public Buyer updateBuyer(Long id, Buyer buyer) throws Exception {
    if(buyerRepository.existsById(id))
      return buyerRepository.save(buyer);
    throw new RuntimeException("No such buyer exists with user id -> "+id);
  }

  @Override
  public Buyer deleteBuyer(Long id) throws Exception {
    if(buyerRepository.existsById(id)) {
      Buyer u = buyerRepository.findById(id).get();
      buyerRepository.delete(u);
      return u;
    }
    throw new RuntimeException("No such seller exists with user id -> "+id);
  }

  @Override
  public List<Buyer> getAllBuyer() throws Exception {

    List<Buyer> sellerList = new ArrayList<>();
    buyerRepository.findAll().forEach(e -> sellerList.add(e));
    return  sellerList;
  }

  @Override
  public Buyer findBuyerByEmailAndAndPassword(String email, String password){
    return buyerRepository.findBuyerByEmailAndPassword(email, password);
  }



}