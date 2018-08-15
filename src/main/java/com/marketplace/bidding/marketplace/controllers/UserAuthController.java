package com.marketplace.bidding.marketplace.controllers;

import com.marketplace.bidding.marketplace.Services.Impl.BuyerServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.SellerServiceImpl;

import com.marketplace.bidding.marketplace.models.AuthUserResponse;
import com.marketplace.bidding.marketplace.models.Buyer;
import com.marketplace.bidding.marketplace.models.Seller;
import com.marketplace.bidding.marketplace.models.UserAuthRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(path = "/user")
public class UserAuthController {

  @Autowired
  private BuyerServiceImpl buyerService;

  @Autowired
  private SellerServiceImpl sellerService;


  @RequestMapping(path = "/auth/buyer", method = RequestMethod.POST)
  public ResponseEntity<AuthUserResponse> loginBuyerUser(@RequestBody UserAuthRequest authRequest) {
    try {

      AuthUserResponse authUserResponse = new AuthUserResponse();
      Buyer buyerUser = buyerService.findBuyerByEmailAndAndPassword(authRequest.getEmail(), authRequest.getPassword());
      authUserResponse.setFirstName(buyerUser.getFirstName());
      authUserResponse.setUserId(buyerUser.getId());

      if (buyerUser == null) {
        return new ResponseEntity<AuthUserResponse>(authUserResponse, HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<AuthUserResponse>(authUserResponse, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<AuthUserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(path = "/auth/seller", method = RequestMethod.POST)
  public ResponseEntity<AuthUserResponse> loginSellerUser(@RequestBody UserAuthRequest authRequest) {

    try {
      AuthUserResponse authUserResponse = new AuthUserResponse();
        Seller sellerUser = sellerService.findBuyerByEmailAndAndPassword(authRequest.getEmail(), authRequest.getPassword());

      authUserResponse.setFirstName(sellerUser.getFirstName());
      authUserResponse.setUserId(sellerUser.getId());
      if (sellerUser == null) {
        return new ResponseEntity<AuthUserResponse>(authUserResponse, HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<AuthUserResponse>(authUserResponse, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<AuthUserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}