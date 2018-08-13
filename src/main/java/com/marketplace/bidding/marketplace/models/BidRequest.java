package com.marketplace.bidding.marketplace.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BidRequest {

  @NotNull
  @JsonProperty("biddingUser")
  String biddingUser;

  @NotNull
  @JsonProperty("projectId")
  String projectId;

  @NotNull
  @JsonProperty("bidAmount")
  String bidAmount;

}
