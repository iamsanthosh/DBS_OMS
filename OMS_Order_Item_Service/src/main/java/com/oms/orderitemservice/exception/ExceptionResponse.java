package com.oms.orderitemservice.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter @AllArgsConstructor
public class ExceptionResponse {
  private Date timestamp;
  private String message;
  private String details;

}