package com.test.bank.controllers;

import com.test.bank.domain.model.ApplicationUser;
import com.test.bank.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationUserController {

  @Autowired
  private ApplicationUserRepository applicationUserRepository;

  @PostMapping("/v1/users")
  public ApplicationUser createPassword(@RequestBody ApplicationUser applicationUser) {
    return applicationUserRepository.save(applicationUser);
  }
}
