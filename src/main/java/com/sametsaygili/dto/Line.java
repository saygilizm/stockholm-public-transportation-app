package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class Line extends ResultContent implements Serializable {

  private static final long serialVersionUID = -804374467105715136L;

  @JsonProperty(value = "LineNumber")
  private String lineNumber;

  @JsonProperty(value = "LineDesignation")
  private String lineDesignation;

  @JsonProperty(value = "DefaultTransportModeCode")
  private String defaultTransportModeCode;

  @JsonProperty(value = "DefaultTransportMode")
  private String defaultTransportMode;

}