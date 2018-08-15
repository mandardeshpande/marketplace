package com.marketplace.bidding.marketplace.controllers;

import com.marketplace.bidding.marketplace.Services.Impl.BuyerServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.SellerServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.UserServiceImpl;

import com.marketplace.bidding.marketplace.models.Buyer;
import com.marketplace.bidding.marketplace.models.User;
import com.marketplace.bidding.marketplace.models.UserAuthRequest;
import java.util.Date;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(path = "/user")
public class UserAuthController {


  @Autowired
  private UserServiceImpl userService;

  @Autowired
  private BuyerServiceImpl buyerService;

  @Autowired
  private SellerServiceImpl sellerService;



  @RequestMapping(path = "/auth/buyer", method = RequestMethod.POST)
  public ResponseEntity<?> loginUser(@RequestBody UserAuthRequest authRequest) {
    try {

      Buyer buyerUser = null;
      if(authRequest.getUserType().equals("buyer")){
         buyerUser = buyerService.findBuyerByEmailAndAndPassword(authRequest.getEmail(), authRequest.getPassword());
      }

      if(buyerUser == null){
        return new ResponseEntity<String>("user not found ", HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<Buyer>(buyerUser, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<Buyer>( HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}