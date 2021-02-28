package com.test.bank.domain.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@Entity
public class ApplicationUser {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private String login;
  private String password;
  @Version
  private Integer version;
  private boolean deleted;
  @CreatedDate
  private Instant createdAt;
  @LastModifiedDate
  private Instant updatedAt;

  public ApplicationUser() {
  }
}
