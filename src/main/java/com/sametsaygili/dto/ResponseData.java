package com.sametsaygili.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData<T> implements Serializable {

  @JsonProperty(value = "Version")
  private String version;

  @JsonProperty(value = "Type")
  private String type;

  @JsonProperty(value = "Result")
  private List<T> result;

}
