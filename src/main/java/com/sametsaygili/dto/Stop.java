package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class Stop extends ResultContent implements Serializable {

  private static final long serialVersionUID = 2767927720010394433L;

  @JsonProperty(value = "StopPointNumber")
  private String stopPointNumber;

  @JsonProperty(value = "StopPointName")
  private String stopPointName;

  @JsonProperty(value = "StopAreaNumber")
  private String stopAreaNumber;

  @JsonProperty(value = "LocationNorthingCoordinate")
  private String locationNorthingCoordinate;

  @JsonProperty(value = "LocationEastingCoordinate")
  private String locationEastingCoordinate;

  @JsonProperty(value = "ZoneShortName")
  private String zoneShortName;

  @JsonProperty(value = "StopAreaTypeCode")
  private String stopAreaTypeCode;

}