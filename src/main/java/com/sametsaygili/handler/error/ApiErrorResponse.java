package com.sametsaygili.handler.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorResponse {

  private String error;
  private String message;

}