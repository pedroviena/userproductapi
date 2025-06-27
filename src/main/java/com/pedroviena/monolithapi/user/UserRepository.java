package com.pedroviena.monolithapi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // O Spring Data JPA vai criar a query "SELECT * FROM users WHERE email = ?" magicamente!
    Optional<User> findByEmail(String email);
}