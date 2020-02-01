package com.sametsaygili.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Data
public class ServiceConfiguration {

  @Value("${sl.api.url}")
  private String slApiUrl;

  @Value("${sl.api.key}")
  private String slApiKey;

  @Bean(name = "restTemplate")
  public RestTemplate getRestTemplate() {
    return new RestTemplateBuilder().build();
  }

}
