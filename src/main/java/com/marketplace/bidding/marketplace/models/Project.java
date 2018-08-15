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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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

  @NotNull
  private String title;
  @NotNull
  private String description;

  @ManyToOne
  @JoinColumn(name = "project_seller_id")
  private Seller seller;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date biddingStartTime;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date biddingEndTime;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date projectDeliveryDate;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date projectPostedDate;

}