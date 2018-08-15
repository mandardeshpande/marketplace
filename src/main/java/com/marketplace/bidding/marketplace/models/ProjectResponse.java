package com.marketplace.bidding.marketplace.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProjectResponse {

  private String projectTitle;
  private String description;
  private Date projectDeliveryDate;
  private String projectSellerFirstName;
}
