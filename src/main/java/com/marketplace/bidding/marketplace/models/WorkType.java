package com.marketplace.bidding.marketplace.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WorkType {

  @JsonProperty("isSeller")
  private boolean isSeller;
  @JsonProperty("workStructure")
  private String workStructure; //hourly or fixed price
  @JsonProperty("hourlyRate")
  private int hourlyRate;
  @JsonProperty("fixedRate")
  private int fixedRate;
}
