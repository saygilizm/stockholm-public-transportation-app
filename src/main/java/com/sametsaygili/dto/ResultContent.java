package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class ResultContent implements Serializable {

  private static final long serialVersionUID = -8724826428851646048L;

  @JsonProperty(value = "LastModifiedUtcDateTime")
  @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
  private Date lastModifiedUtcDateTime;

  @JsonProperty(value = "ExistsFromDate")
  @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
  private Date existsFromDate;

}
