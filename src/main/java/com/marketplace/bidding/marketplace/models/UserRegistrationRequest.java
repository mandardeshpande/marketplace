package com.marketplace.bidding.marketplace.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegistrationRequest {

  @NotNull
  @JsonProperty("firstName")
  private String firstName;

  @NotNull
  @JsonProperty("lastName")
  private String lastName;

  @NotNull
  @JsonProperty("email")
  private String email;

  @NotNull
  @JsonProperty("password")
  private String password;

  @NotNull
  @JsonProperty("userRating")
  private int userRating;

  @JsonProperty("workStructure")
  private String workStructure; //hourly or fixed price
  @JsonProperty("hourlyRate")
  private int hourlyRate;
  @JsonProperty("fixedRate")
  private int fixedRate;
}
