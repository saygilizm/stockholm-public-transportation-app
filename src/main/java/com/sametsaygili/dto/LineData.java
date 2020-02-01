package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
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
