package com.sametsaygili.provider;

import com.sametsaygili.controller.ServiceConfiguration;
import com.sametsaygili.dto.LineData;
import com.sametsaygili.dto.ResultContent;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class SLApiRestCaller {

  @Autowired
  private ServiceConfiguration serviceConfiguration;

  public <T extends ResultContent> LineData<T> retrieveLineData(Map<String, String> queryParams, ParameterizedTypeReference<LineData<T>> type) {

    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(serviceConfiguration.getSlApiUrl())
        .queryParam("key", serviceConfiguration.getSlApiKey());

    queryParams.forEach((k, v) -> builder.queryParam(k, v));

    return serviceConfiguration
        .getRestTemplate().exchange(builder.build().toUri(), HttpMethod.GET, null, type)
        .getBody();

  }

}
