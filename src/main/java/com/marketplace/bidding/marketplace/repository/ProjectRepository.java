package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.models.Seller;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
  List<Project> findBySeller(Seller seller);

  @Query(value = "SELECT * FROM Project ORDER BY project_posted_date DESC ", nativeQuery = true)
  List<Project> findProjectsByProjectPostedDate();
}