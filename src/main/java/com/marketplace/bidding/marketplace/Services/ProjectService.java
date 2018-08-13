package com.marketplace.bidding.marketplace.Services;

import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.models.Seller;
import java.util.List;

public interface ProjectService {

  Project getById(Long id)throws Exception;

  Project addNewProject(Project project)throws Exception;

  Project updateProject(Long id, Project project)throws Exception;

  Project deleteProject(Long id)throws Exception;

  List<Project> findBySeller(Seller sellerId) throws Exception;

  List<Project> findAllProjectBeforeBidEndTime() throws Exception;
}
