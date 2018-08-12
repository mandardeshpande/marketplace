package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}