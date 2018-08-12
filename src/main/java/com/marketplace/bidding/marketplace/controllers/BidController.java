package com.marketplace.bidding.marketplace.controllers;


import com.marketplace.bidding.marketplace.Services.BidService;
import com.marketplace.bidding.marketplace.models.Bid;
import java.util.List;

import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("bid")
public class BidController {

  @Autowired
  BidService bidService;

  @RequestMapping(value = "/{bidId}", method = RequestMethod.GET)
  public ResponseEntity<Bid> getBidById(@PathVariable("bidId") String bidId) {
    try {
      bidService.getById(Long.parseLong(bidId));
      return new ResponseEntity<Bid>(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<Bid>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity<Bid> addNewBid(@RequestBody Bid bid) {
    try {
      bidService.addNewBid(bid);
      return new ResponseEntity<Bid>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Bid>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public ResponseEntity<List<Bid>> getAllAuctions() {
    try {
      bidService.getAllActive();
      return new ResponseEntity<List<Bid>>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<List<Bid>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @RequestMapping(value = "/{bidId}", method = RequestMethod.PUT)
  public ResponseEntity<?> updateAuction(@PathVariable("bidId") Long bidId,
      @RequestBody Bid bid) {
    try {
      bidService.updateBid(bidId, bid);
      return new ResponseEntity<Bid>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Bid>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}