package com.marketplace.bidding.marketplace.controllers;

import com.marketplace.bidding.marketplace.Services.Impl.SellerServiceImpl;
import com.marketplace.bidding.marketplace.models.Seller;
import com.marketplace.bidding.marketplace.models.UserRegistrationRequest;
import java.util.Date;
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
@RequestMapping(path = "/seller")
public class SellerController {


  @Autowired
  private SellerServiceImpl sellerService;

  @RequestMapping(path = "/add", method = RequestMethod.POST)
  public ResponseEntity<Seller> addNewUser(@RequestBody UserRegistrationRequest request) {
    try {

      Seller seller = new Seller();

      seller.setFirstName(request.getFirstName());
      seller.setLastName(request.getLastName());
      seller.setEmail(request.getEmail());
      seller.setJoiningDate(new Date());
      seller.setPassword(request.getPassword());
      seller.setUserRating(request.getUserRating());


      Seller newUser = sellerService.addSeller(seller);
      return new ResponseEntity<Seller>(newUser,HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<Seller>( HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }

  @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
  public ResponseEntity<Seller> getUser(@PathVariable("userId") Long userId) {
    try {

      Seller user = sellerService.getById(userId);
      return new ResponseEntity<Seller>(user,HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<Seller>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }

  @RequestMapping(path = "/all", method = RequestMethod.GET)
  public ResponseEntity<List<Seller>> getAllUsers() {
    try {

      List<Seller> list = sellerService.getAllSeller();
      return new ResponseEntity<List<Seller>>(list,HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<List<Seller>>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }
}