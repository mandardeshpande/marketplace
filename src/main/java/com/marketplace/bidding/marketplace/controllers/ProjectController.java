package com.marketplace.bidding.marketplace.controllers;


import com.marketplace.bidding.marketplace.Services.BidService;
import com.marketplace.bidding.marketplace.Services.Impl.ProjectServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.SellerServiceImpl;
import com.marketplace.bidding.marketplace.Services.Impl.UserServiceImpl;
import com.marketplace.bidding.marketplace.models.Bid;
import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.models.Seller;
import com.marketplace.bidding.marketplace.models.User;
import java.util.ArrayList;
import java.util.Date;
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

  @Autowired
  UserServiceImpl userService;

  @Autowired
  SellerServiceImpl sellerService;


  @RequestMapping(value = "/{sellerId}", method = RequestMethod.GET)
  public ResponseEntity<List<Project>> getBidById(@PathVariable("sellerId") Long sellerId) {
    try {
      List<Project> projectBySellerId = projectService.findBySeller(sellerService.getById(sellerId));
      return new ResponseEntity(projectBySellerId, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/post/{sellerId}", method = RequestMethod.POST)
  public ResponseEntity<Project> postNewProject(@PathVariable("sellerId") Long sellerId,@RequestBody Project project) {
    try {
      Seller seller = sellerService.getById(sellerId);

      if(seller == null){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
      }

      project.setSeller(seller);
      project.setProjectPostedDate(new Date());
      Project newProject = projectService.addNewProject(project);
      return new ResponseEntity(newProject, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @RequestMapping(value = "/all/beforebidendtime", method = RequestMethod.GET)
  public ResponseEntity<List<Project>> getAllProjectsBeforeBiddingDeadline() {
    try {
      List<Project> projectBeforeBiddingEnds = projectService.findAllProjectBeforeBidEndTime();
      return new ResponseEntity(projectBeforeBiddingEnds,HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}