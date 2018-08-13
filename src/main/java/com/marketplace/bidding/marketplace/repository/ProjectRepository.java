package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.models.Seller;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
  List<Project> findBySeller(Seller seller);

  List<Project> findProjectByBiddingEndTime();
}