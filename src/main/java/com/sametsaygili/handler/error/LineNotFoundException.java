package com.sametsaygili.handler.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineNotFoundException extends RuntimeException {

  private long id;

}