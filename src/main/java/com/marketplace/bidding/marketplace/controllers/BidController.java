package com.marketplace.bidding.marketplace.controllers;


import com.marketplace.bidding.marketplace.Services.BidService;
import com.marketplace.bidding.marketplace.Services.Impl.BuyerServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.ProjectServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.UserServiceImpl;
import com.marketplace.bidding.marketplace.models.Bid;
import com.marketplace.bidding.marketplace.models.BidRequest;
import com.marketplace.bidding.marketplace.models.BidResponse;
import com.marketplace.bidding.marketplace.models.Buyer;
import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.models.ProjectResponse;
import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;
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

  @Autowired
  UserServiceImpl userService;

  @Autowired
  BuyerServiceImpl buyerService;

  @Autowired
  ProjectServiceImpl projectService;

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
  public ResponseEntity<Bid> addNewBid(@RequestBody BidRequest bidRequest) {
    try {

      Buyer buyer = buyerService.getById(Long.parseLong(bidRequest.getBiddingUser()));
      Project project = projectService.getById(Long.parseLong(bidRequest.getProjectId()));

      Bid bid = new Bid();

      bid.setBidTime(new Date());
      bid.setAmount(Double.parseDouble(bidRequest.getBidAmount()));
      bid.setBuyer(buyer);
      bid.setProject(project);

      Bid newPostedBid = bidService.addNewBid(bid);
      return new ResponseEntity<Bid>(newPostedBid,HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Bid>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public ResponseEntity<List<Bid>> getAllBids() {
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

  @RequestMapping(value = "/winning", method = RequestMethod.GET)
  public ResponseEntity<?> getWinning() {
    try {
      List<Bid> p = bidService.getWinningProjectByLowBidAmount();
      return new ResponseEntity<List<Bid>>(p, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Bid>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/winning/{buyerId}", method = RequestMethod.GET)
  public ResponseEntity<?> getWinningBuyerDetails(@PathVariable("buyerId") Long buyerId) {
    try {
      List<BidResponse> p = bidService.getAllBidsForProjectId(buyerId).stream().map(eachBid->{
        BidResponse response = new BidResponse();
        response.setBidAmount(eachBid.getAmount());
        response.setBidderFirstName(eachBid.getBuyer().getFirstName());
        response.setBidTime(eachBid.getBidTime());
        response.setProjectTitle(eachBid.getProject().getTitle());
        response.setProjectDescription(eachBid.getProject().getDescription());
        return response;
      }).collect(Collectors.toList());
      return new ResponseEntity<List<BidResponse>>(p, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<List<BidResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/project/{sellerId}", method = RequestMethod.GET)
  public ResponseEntity<?> getAllBidsForSellerId( @PathVariable("sellerId") Long projectSellerId) {
    try {
      List<BidResponse> p = bidService.getAllBidsForProjectId(projectSellerId).stream().map(eachBid->{
        BidResponse response = new BidResponse();
        response.setBidAmount(eachBid.getAmount());
        response.setBidderFirstName(eachBid.getBuyer().getFirstName());
        response.setBidTime(eachBid.getBidTime());
        response.setProjectTitle(eachBid.getProject().getTitle());
        response.setProjectDescription(eachBid.getProject().getDescription());
        return response;
      }).collect(Collectors.toList());
      return new ResponseEntity<List<BidResponse>>(p, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<List<BidResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/project/buyer/{buyerId}", method = RequestMethod.GET)
  public ResponseEntity<?> getAllBidsByBuyerId( @PathVariable("buyerId") Long projectBuyerId) {
    try {
      List<BidResponse> p = bidService.getAllBidsByBuyerId(projectBuyerId).stream().map(eachBid->{
        BidResponse response = new BidResponse();
        response.setBidAmount(eachBid.getAmount());
        response.setBidderFirstName(eachBid.getBuyer().getFirstName());
        response.setBidTime(eachBid.getBidTime());
        response.setProjectTitle(eachBid.getProject().getTitle());
        response.setProjectDescription(eachBid.getProject().getDescription());

        return response;
      }).collect(Collectors.toList());
      return new ResponseEntity<List<BidResponse>>(p, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<List<BidResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}