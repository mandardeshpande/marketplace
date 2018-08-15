package com.marketplace.bidding.marketplace.Services.Impl;

import com.marketplace.bidding.marketplace.Services.SellerService;
import com.marketplace.bidding.marketplace.Services.UserService;
import com.marketplace.bidding.marketplace.models.Buyer;
import com.marketplace.bidding.marketplace.models.Seller;
import com.marketplace.bidding.marketplace.models.User;
import com.marketplace.bidding.marketplace.repository.SellerRepository;
import com.marketplace.bidding.marketplace.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

  @Autowired
  SellerRepository sellerRepository;

  @Override
  public Seller getById(Long id) throws Exception {
    return sellerRepository.findById(id).get();
  }

  @Override
  public Seller addSeller(Seller seller) throws Exception {
    return sellerRepository.save(seller);
  }

  @Override
  public Seller updateSeller(Long id, Seller seller) throws Exception {
    if(sellerRepository.existsById(id))
      return sellerRepository.save(seller);
    throw new RuntimeException("No such seller exists with user id -> "+id);
  }

  @Override
  public Seller deleteSeller(Long id) throws Exception {
    if(sellerRepository.existsById(id)) {
      Seller u = sellerRepository.findById(id).get();
      sellerRepository.delete(u);
      return u;
    }
    throw new RuntimeException("No such seller exists with user id -> "+id);
  }

  @Override
  public List<Seller> getAllSeller() throws Exception {

    List<Seller> sellerList = new ArrayList<>();
    sellerRepository.findAll().forEach(e -> sellerList.add(e));
    return  sellerList;
  }

  @Override
  public Seller findBuyerByEmailAndAndPassword(String email, String password){
    return sellerRepository.findSellerByEmailAndPassword(email, password);
  }

}