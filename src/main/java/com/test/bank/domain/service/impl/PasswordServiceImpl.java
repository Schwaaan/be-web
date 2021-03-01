package com.test.bank.domain.service.impl;

import com.test.bank.domain.model.Password;
import com.test.bank.domain.model.Status;
import com.test.bank.domain.model.Type;
import com.test.bank.domain.service.PasswordService;
import com.test.bank.repository.PasswordRepository;
import com.test.bank.utils.Assert;
import java.time.Instant;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

  @Autowired
  private PasswordRepository passwordRepository;

  @Override
  public Password createPassword(Password password) {
    long sizePassword = passwordRepository.count();
    if (password.getType().equals(Type.NORMAL)) {
      password.setValue("N" + sizePassword);
      return passwordRepository.save(password);
    }
    password.setValue("P" + sizePassword);
    return passwordRepository.save(password);
  }

  @Override
  public Password getPassword() {
    Optional<Password> passwordOptional = passwordRepository
        .findFirstByDeletedIsFalseAndTypeAndStatusOrderByCreatedAtAsc(Type.PREFERENCIAL,
            Status.PENDING);
    if (!passwordOptional.isPresent()) {
      Password password = Assert.found(passwordRepository
          .findFirstByDeletedIsFalseAndTypeAndStatusOrderByCreatedAtAsc(Type.NORMAL,
              Status.PENDING), "Password not found");
      return this.updatePassword(password);
    }
    return this.updatePassword(passwordOptional.get());
  }

  private Password updatePassword(Password password) {
    password.setStatus(Status.CALLING);
    password.setCallingAt(Instant.now());
    return passwordRepository.save(password);
  }
}
