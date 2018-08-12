package com.marketplace.bidding.marketplace.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegistrationRequest {

  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("email")
  private String email;
  @JsonProperty("password")
  private String password;

  @JsonProperty("userRating")
  private int userRating;
  @JsonProperty("isSeller")
  private boolean isSeller;
  @JsonProperty("workStructure")
  private String workStructure; //hourly or fixed price
  @JsonProperty("hourlyRate")
  private int hourlyRate;
  @JsonProperty("fixedRate")
  private int fixedRate;
}
