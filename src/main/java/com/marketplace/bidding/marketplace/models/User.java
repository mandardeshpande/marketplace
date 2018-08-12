package com.marketplace.bidding.marketplace.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Getter
@Setter
@ToString
@Entity
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long Id;

  private String firstName;
  private String lastName;
  private String email;
  private String password;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATED_DATE", updatable = false)
  private Date joiningDate;

  private int userRating;

}