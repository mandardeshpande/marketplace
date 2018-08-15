package com.marketplace.bidding.marketplace.models;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
  private Long id;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date bidTime;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "buyer_user_id")
  private Buyer buyer;

  @NotNull
  private Double amount;

}