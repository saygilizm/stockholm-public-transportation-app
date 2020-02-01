package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineData<T> implements Serializable {

  private static final long serialVersionUID = 982679563345898554L;

  @JsonProperty(value = "StatusCode")
  private Integer statusCode;

  @JsonProperty(value = "Message")
  private String message;

  @JsonProperty(value = "ExecutionTime")
  private Integer executionTime;

  @JsonProperty(value = "ResponseData")
  private ResponseData<T> responseData;

}
