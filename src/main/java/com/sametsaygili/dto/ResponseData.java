package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ResponseData<T> implements Serializable {

  private static final long serialVersionUID = -1635764117443725849L;

  @JsonProperty(value = "Version")
  private String version;

  @JsonProperty(value = "Type")
  private String type;

  @JsonProperty(value = "Result")
  private List<T> result;

}
