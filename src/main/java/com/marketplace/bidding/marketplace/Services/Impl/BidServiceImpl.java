package com.marketplace.bidding.marketplace.Services.Impl;


import com.marketplace.bidding.marketplace.Services.BidService;
import com.marketplace.bidding.marketplace.models.Bid;
import com.marketplace.bidding.marketplace.models.Project;
import com.marketplace.bidding.marketplace.repository.BidRepository;
import com.marketplace.bidding.marketplace.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

  @Autowired
  BidRepository BidRepository;

  @Autowired
  ProjectServiceImpl projectService;

  @Autowired
  BidInformationServiceImpl bidInformationService;


  @Override
  public Bid getById(Long id) throws Exception {
    return BidRepository.findById(id).get();
  }

  @Override
  public Bid addNewBid(Bid bid) throws Exception {
    return BidRepository.save(bid);
  }

  @Override
  public Bid updateBid(Long id, Bid bid) throws Exception {
    if (BidRepository.existsById(id)) {
      return BidRepository.save(bid);
    }
    throw new RuntimeException("No such Bid exists with Bid id -> " + id);
  }

  @Override
  public Bid deleteBid(Long id) throws Exception {
    if (BidRepository.existsById(id)) {
      Bid u = BidRepository.findById(id).get();
      BidRepository.delete(u);
      return u;
    }
    throw new RuntimeException("No such Auction exists with bid id -> " + id);
  }

  @Override
  public List<Bid> getAllActive() throws Exception {
    List<Bid> bidList = new ArrayList<>();
    BidRepository.findAll().forEach(e -> bidList.add(e));
    return bidList;
  }

  @Override
  public List<Project> getWinningProjectByLowBidAmount() throws Exception {

    List<Project> projectListBeforeBidDeadline = projectService.findAllProjectBeforeBidEndTime();

    Iterator<Bid> sourceIterator = BidRepository.findAll().iterator();
    Iterable<Bid> iterable = () -> sourceIterator;

    Bid bidWithMinimumAmount = StreamSupport
        .stream(iterable.spliterator(), false)
        .min(Comparator.comparing(i -> i.getAmount()))
        .orElse(new Bid());

    List<Project> winningProjectList = projectListBeforeBidDeadline
        .stream()
        .filter(project -> bidWithMinimumAmount.getProject().getId().equals(project.getId()))
        .collect(Collectors.toList());

    return winningProjectList;

  }

  @Override
  public List<Project> getWinningProjectLowestAmountAndBuyerId(Long buyerId) throws Exception {

    List<Project> projectListBeforeBidDeadline = projectService.findAllProjectBeforeBidEndTime();

    Iterator<Bid> sourceIterator = BidRepository.findAll().iterator();
    Iterable<Bid> iterable = () -> sourceIterator;

    Bid bidWithMinimumAmount = StreamSupport
        .stream(iterable.spliterator(), false)
        .min(Comparator.comparing(i -> i.getAmount()))
        .orElse(new Bid());

    return projectListBeforeBidDeadline
        .stream()
        .filter(project -> bidWithMinimumAmount.getProject().getId().equals(project.getId())
            && bidWithMinimumAmount.getBuyer().getId().equals(buyerId))
        .collect(Collectors.toList());
  }

  @Override
  public List<Bid> getAllBidsForProjectId(Long projectSellerId) throws Exception {
    List<Bid> bids = BidRepository.findBidsByProject_Seller_Id(projectSellerId);
    return bids;
  }

  @Override
  public List<Bid> getAllBidsByBuyerId(Long projectBuyerId) throws Exception {
    List<Bid> bids = BidRepository.findBidsByBuyer_Id(projectBuyerId);
    return bids;
  }

}