package com.marketplace.bidding.marketplace.Services.Impl;

import com.marketplace.bidding.marketplace.Services.UserService;
import com.marketplace.bidding.marketplace.models.User;
import com.marketplace.bidding.marketplace.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public User getById(Long id) throws Exception {
    return userRepository.findById(id).get();
  }

  @Override
  public User addNewUser(User user) throws Exception {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(Long id, User user) throws Exception {
    if(userRepository.existsById(id))
      return userRepository.save(user);
    throw new RuntimeException("No such user exists with user id -> "+id);
  }

  @Override
  public User deleteUser(Long id) throws Exception {
    if(userRepository.existsById(id)) {
      User u = userRepository.findById(id).get();
      userRepository.delete(u);
      return u;
    }
    throw new RuntimeException("No such user exists with user id -> "+id);
  }

  @Override
  public List<User> getAllUser() throws Exception {

    List<User> userList = new ArrayList<>();
       userRepository.findAll().forEach(e -> userList.add(e));
       return  userList;
  }

}