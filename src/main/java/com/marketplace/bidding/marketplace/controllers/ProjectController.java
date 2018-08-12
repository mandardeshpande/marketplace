package com.marketplace.bidding.marketplace.controllers;


import com.marketplace.bidding.marketplace.Services.BidService;
import com.marketplace.bidding.marketplace.Services.Impl.ProjectServiceImpl;
import com.marketplace.bidding.marketplace.models.Bid;
import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.models.Seller;
import com.marketplace.bidding.marketplace.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("project")
public class ProjectController {

  @Autowired
  ProjectServiceImpl projectService;

//  @RequestMapping(value = "/{sellerId}", method = RequestMethod.GET)
//  public ResponseEntity<Bid> getBidById(@PathVariable("sellerId") String bidId) {
//    try {
//      projectService.getById()
//      return new ResponseEntity<Bid>(HttpStatus.OK);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return new ResponseEntity<Bid>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }

  @RequestMapping(value = "/post/{sellerId}", method = RequestMethod.POST)
  public ResponseEntity<Project> postNewProject(@PathVariable("sellerId") Long sellerId,@RequestBody Project project) {
    try {
      User sellerUser = new User();
      sellerUser.setId(sellerId);

      Seller seller = new Seller();
      seller.setUser(sellerUser);

      project.setSeller(seller);
      Project newProject = projectService.addNewProject(project);
      return new ResponseEntity<Project>(newProject, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

//  @RequestMapping(value = "/all", method = RequestMethod.GET)
//  public ResponseEntity<List<Bid>> getAllAuctions() {
//    try {
//      bidService.getAllActive();
//      return new ResponseEntity<List<Bid>>(HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<List<Bid>>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
//
//
//  @RequestMapping(value = "/{bidId}", method = RequestMethod.PUT)
//  public ResponseEntity<?> updateAuction(@PathVariable("bidId") Long bidId,
//      @RequestBody Bid bid) {
//    try {
//      bidService.updateBid(bidId, bid);
//      return new ResponseEntity<Bid>(HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<Bid>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }

}