package com.test.bank.controllers;

import com.test.bank.domain.model.ApplicationUser;
import com.test.bank.repository.ApplicationUserRepository;
import com.test.bank.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

  @Autowired
  private ApplicationUserRepository applicationUserRepository;

  @PostMapping("/v1/login")
  public ApplicationUser createPassword(@RequestBody ApplicationUser applicationUser) {
    return Assert.found(applicationUserRepository
            .findOneByLoginAndPassword(applicationUser.getLogin(), applicationUser.getPassword()),
        "User not found");
  }
}
