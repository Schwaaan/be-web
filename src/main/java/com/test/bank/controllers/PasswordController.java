package com.test.bank.controllers;

import com.test.bank.domain.model.Password;
import com.test.bank.domain.model.Status;
import com.test.bank.domain.service.PasswordService;
import com.test.bank.repository.PasswordRepository;
import com.test.bank.utils.Assert;
import java.time.Instant;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PasswordController {

  private PasswordRepository passwordRepository;
  private PasswordService passwordService;

  @PostMapping("/v1/passwords")
  public Password createPassword(@RequestBody Password password) {
    password.setCreatedAt(Instant.now());
    return passwordService.createPassword(password);
  }

  @GetMapping("/v1/passwords")
  public Page<Password> findAll(@PageableDefault Pageable pageable) {
    return passwordRepository.findAll(pageable);
  }

  @GetMapping("/v1/passwords/callings")
  public Password findLastPasswordCalling() {
    return Assert.found(passwordRepository.findFirstByDeletedIsFalseAndStatusOrderByCreatedAtAsc(Status.CALLING), "Nenhuma senha sendo chamada");
  }

  @PutMapping("/v1/passwords/calls")
  public Password callPassword() {
    return passwordService.getPassword();
  }

  @PutMapping("/v1/passwords/{id}")
  public Password callPassword(@PathVariable("id") String id) {
    return Assert.found(passwordRepository.findOneByIdAndDeletedIsFalse(id), "Password not found");
  }

  @DeleteMapping("/v1/passwords")
  public void reloadPasswords() {
    passwordRepository.deleteAll();
  }
}
