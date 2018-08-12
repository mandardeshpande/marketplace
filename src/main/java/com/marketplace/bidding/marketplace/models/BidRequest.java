package com.marketplace.bidding.marketplace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BidRequest {

  @JsonProperty("biddingUser")
  String biddingUser;

  @JsonProperty("projectId")
  String projectId;

  @JsonProperty("bidAmount")
  String bidAmount;

}
