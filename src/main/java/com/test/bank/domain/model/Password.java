package com.test.bank.domain.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Data;

@Data
@Entity
public class Password {

  @Id
  @GeneratedValue
  private Integer id;
  @Version
  private Integer version;
  private boolean deleted;
  private Instant createdAt;
  private String value;
  private Type type;
  private Status status;

  public Password() {
  }
}
