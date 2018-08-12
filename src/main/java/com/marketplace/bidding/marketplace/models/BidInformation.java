package com.marketplace.bidding.marketplace.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@Entity
public class BidInformation  {


  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "bid_id")
  private Bid bid;


  private Double winningAmount;

}