package com.sametsaygili.handler.error;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LineNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -1070340146062150878L;

  private long id;
}