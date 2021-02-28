package com.test.bank.domain.service;

import com.test.bank.domain.model.Password;

public interface PasswordService {

  Password createPassword(Password password);

  Password getPassword();

}
