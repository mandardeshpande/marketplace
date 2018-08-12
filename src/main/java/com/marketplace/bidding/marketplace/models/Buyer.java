package com.marketplace.bidding.marketplace.models;


import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Buyer {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long Id;

  private String firstName;
  private String lastName;
  private String email;
  private String password;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATED_DATE", updatable = false)
  private Date joiningDate;

  private int userRating;

  private String workStructure; //hourly or fixed price

  private int hourlyRate;
  private int fixedRate;
}
