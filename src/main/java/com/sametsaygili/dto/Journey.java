package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;


@Data
public class Journey extends ResultContent implements Serializable {

  @JsonProperty(value = "LineNumber")
  private String lineNumber;

  @JsonProperty(value = "DirectionCode")
  private String directionCode;

  @JsonProperty(value = "JourneyPatternPointNumber")
  private String journeyPatternPointNumber;

}