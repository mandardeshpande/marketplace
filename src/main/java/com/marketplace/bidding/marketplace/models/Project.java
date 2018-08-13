package com.marketplace.bidding.marketplace.models;


import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Project {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;

  @ManyToOne
  @JoinColumn(name = "project_seller_id")
  private Seller seller;

  private Date biddingStartTime;
  private Date biddingEndTime;
  private Date projectDeliveryDate;

}