package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class ResultContent {


  @JsonProperty(value = "LastModifiedUtcDateTime")
  @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
  private Date lastModifiedUtcDateTime;

  @JsonProperty(value = "ExistsFromDate")
  @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
  private Date existsFromDate;

}
