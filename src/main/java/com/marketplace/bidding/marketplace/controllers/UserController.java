package com.marketplace.bidding.marketplace.controllers;

import com.marketplace.bidding.marketplace.Services.Impl.UserServiceImpl;

import com.marketplace.bidding.marketplace.models.User;
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
public class UserController {


  @Autowired
  private UserServiceImpl userService;

  @RequestMapping(path = "/add", method = RequestMethod.POST)
  public ResponseEntity<Long> addNewUser(@RequestBody User user) {
    try {
      User newUser = userService.addNewUser(user);
      return new ResponseEntity<Long>(newUser.getId(),HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<Long>( HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }

  @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
  public ResponseEntity<User> getUser(@PathVariable("userId") Long userId) {
    try {

      User user = userService.getById(userId);
      return new ResponseEntity<User>(user,HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }

  @RequestMapping(path = "/all", method = RequestMethod.GET)
  public ResponseEntity<List<User>> getAllUsers() {
    try {

      List<User> list = userService.getAllUser();
      return new ResponseEntity<List<User>>(list,HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
  }
}