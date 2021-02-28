package com.test.bank.utils;

public class NotFoundException extends RuntimeException {


  public NotFoundException() {
  }

  public NotFoundException(String var1) {
    super(var1);
  }

  public NotFoundException(Throwable var1) {
    super(var1);
  }
}