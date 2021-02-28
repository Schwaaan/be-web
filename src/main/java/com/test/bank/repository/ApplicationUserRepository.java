package com.test.bank.repository;

import com.test.bank.domain.model.ApplicationUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

  Optional<ApplicationUser> findOneByLoginAndPassword(String login, String password);
}
