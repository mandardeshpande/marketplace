package com.marketplace.bidding.marketplace.models;


import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class BidResponse {

  private String projectTitle;
  private String projectDescription;

  private String bidderFirstName;
  private Double bidAmount;

  @Temporal(TemporalType.TIMESTAMP)
  private Date bidTime;
}
