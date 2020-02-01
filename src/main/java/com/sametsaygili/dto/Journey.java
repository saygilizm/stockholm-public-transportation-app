package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
public class Journey extends ResultContent implements Serializable {

  private static final long serialVersionUID = 2022910902412283846L;

  @JsonProperty(value = "LineNumber")
  private String lineNumber;

  @JsonProperty(value = "DirectionCode")
  private String directionCode;

  @JsonProperty(value = "JourneyPatternPointNumber")
  private String journeyPatternPointNumber;

}