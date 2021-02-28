package com.test.bank.repository;

import com.test.bank.domain.model.Password;
import com.test.bank.domain.model.Status;
import com.test.bank.domain.model.Type;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {

  Optional<Password> findOneByIdAndDeletedIsFalse(String id);

  Optional<Password> findFirstByDeletedIsFalseAndTypeAndStatusOrderByCreatedAtAsc(Type type, Status status);

}
