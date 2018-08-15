package com.marketplace.bidding.marketplace.Services.Impl;


import com.marketplace.bidding.marketplace.Services.ProjectService;
import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.models.Seller;
import com.marketplace.bidding.marketplace.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  ProjectRepository projectRepository;


  @Override
  public Project getById(Long id) throws Exception {
    return projectRepository.findById(id).get();
  }

  @Override
  public Project addNewProject(Project project) throws Exception {
    return projectRepository.save(project);
  }

  @Override
  public Project updateProject(Long id, Project project) throws Exception {
    if(projectRepository.existsById(id))
      return projectRepository.save(project);
    throw new RuntimeException("No such Bid exists with Project id -> "+id);
  }

  @Override
  public Project deleteProject(Long id) throws Exception {
    if(projectRepository.existsById(id)) {
      Project u = projectRepository.findById(id).get();
      projectRepository.delete(u);
      return u;
    }
    throw new RuntimeException("No such Auction exists with Auction id -> "+id);
  }

  @Override
  public List<Project> findBySeller(Seller sellerId){
    List<Project> projectList = new ArrayList<>();
    projectRepository.findBySeller(sellerId).forEach(e->projectList.add(e));
    return projectList;
  }

  @Override
  public List<Project> findAllProjectBeforeBidEndTime(){
    Date currentDate = new Date(System.currentTimeMillis());
    Iterator<Project> sourceIterator = projectRepository.findAll().iterator();
    Iterable<Project> iterable = () -> sourceIterator;

    return StreamSupport.stream(iterable.spliterator(),false)
        .filter(project-> project.getBiddingEndTime().before(currentDate))
        .collect(Collectors.toList());
  }

  @Override
  public List<Project> findAllProjectsPostedNow(){

    Iterator<Project> sourceIterator = projectRepository.findProjectsByProjectPostedDate().iterator();
    Iterable<Project> iterable = () -> sourceIterator;
    return StreamSupport.stream(iterable.spliterator(),false)
        .collect(Collectors.toList());
  }
}