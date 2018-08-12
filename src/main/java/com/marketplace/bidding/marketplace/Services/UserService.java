package com.marketplace.bidding.marketplace.Services;

import com.marketplace.bidding.marketplace.models.User;
import java.util.List;

public interface UserService {

    User getById(Long id)throws Exception;

    User addNewUser(User user)throws Exception;

    User updateUser(Long id,User user)throws Exception;

    User deleteUser(Long id)throws Exception;

    List<User> getAllUser() throws Exception;

  }

