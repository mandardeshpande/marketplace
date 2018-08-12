package com.marketplace.bidding.marketplace.repository;


import com.marketplace.bidding.marketplace.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
}