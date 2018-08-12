package com.marketplace.bidding.marketplace.controllers;

import com.marketplace.bidding.marketplace.Services.Impl.BuyerServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.SellerServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.UserServiceImpl;
import com.marketplace.bidding.marketplace.models.Buyer;
import com.marketplace.bidding.marketplace.models.Seller;
import com.marketplace.bidding.marketplace.models.User;
import com.marketplace.bidding.marketplace.models.WorkType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(path = "/work")
public class BuyerSellerController {


  @Autowired
  private SellerServiceImpl sellerService;

  @Autowired
  private BuyerServiceImpl buyerService;



  @RequestMapping(path = "/registerUserType/{userId}", method = RequestMethod.POST)
  public ResponseEntity<?> addUserType(@PathVariable("userId") String userId, @RequestBody WorkType work) {
    try {
      boolean isUserSellerType = work.isSeller();

      if(isUserSellerType){
        Seller seller = new Seller();
        User sellerUser = new User();
        sellerUser.setId(Long.parseLong(userId));

        //List<User> sellerList = new ArrayList<>();
        //sellerList.add(sellerUser);

        seller.setSellerUser(sellerUser);

        sellerService.addSeller(seller);
      } else {

        Buyer buyer = new Buyer();
        buyer.setFixedRate(work.getFixedRate());
        buyer.setHourlyRate(work.getHourlyRate());
        buyer.setWorkStructure(work.getWorkStructure());
        User buyerUser = new User();
        buyerUser.setId(Long.parseLong(userId));

        //List<User> buyerList = new ArrayList<>();
        //buyerList.add(buyerUser);

        buyer.setBuyerUser(buyerUser);
        buyerService.registerBuyer(buyer);
      }

      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}