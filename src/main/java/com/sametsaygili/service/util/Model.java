package com.sametsaygili.service.util;

import lombok.Getter;

@Getter
public enum Model {

  LINE("line"),
  JOURNEY("jour"),
  STOP("stop");

  private String value;

  Model(String value){
    this.value = value;
  }

}
