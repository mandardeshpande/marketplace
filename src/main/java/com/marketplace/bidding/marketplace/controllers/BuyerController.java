package com.marketplace.bidding.marketplace.controllers;

import com.marketplace.bidding.marketplace.Services.Impl.BuyerServiceImpl;
import com.marketplace.bidding.marketplace.models.Buyer;
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
@RequestMapping(path = "/buyer")
public class BuyerController {


  @Autowired
  private BuyerServiceImpl buyerService;

  @RequestMapping(path = "/add", method = RequestMethod.POST)
  public ResponseEntity<Buyer> addNewUser(@RequestBody UserRegistrationRequest request) {
    try {

      Buyer buyer = new Buyer();

      buyer.setFirstName(request.getFirstName());
      buyer.setLastName(request.getLastName());
      buyer.setEmail(request.getEmail());
      buyer.setJoiningDate(new Date());
      buyer.setPassword(request.getPassword());
      buyer.setUserRating(request.getUserRating());

      buyer.setWorkStructure(request.getWorkStructure());
      buyer.setHourlyRate(request.getHourlyRate());
      buyer.setFixedRate(request.getFixedRate());

      Buyer newUser = buyerService.registerBuyer(buyer);
      return new ResponseEntity<Buyer>(newUser,HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<Buyer>( HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }

  @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
  public ResponseEntity<Buyer> getUser(@PathVariable("userId") Long userId) {
    try {

      Buyer user = buyerService.getById(userId);
      return new ResponseEntity<Buyer>(user,HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<Buyer>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }

  @RequestMapping(path = "/all", method = RequestMethod.GET)
  public ResponseEntity<List<Buyer>> getAllUsers() {
    try {

      List<Buyer> list = buyerService.getAllBuyer();
      return new ResponseEntity<List<Buyer>>(list,HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<List<Buyer>>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }
}