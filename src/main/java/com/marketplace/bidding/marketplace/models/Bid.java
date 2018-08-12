package com.marketplace.bidding.marketplace.models;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@Entity
public class Bid {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long Id;

  private Date bidTime;

  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;

  @ManyToOne
  @JoinColumn(name = "buyer_user_id")
  private Buyer buyer;

  private Double startingAmount;

}