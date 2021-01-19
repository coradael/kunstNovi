package com.kunstNovi.repository;

import com.kunstNovi.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);

    Optional<user> findByUsernameOrEmail(String username, String email);

    List<user> findByIdIn(List<Long> userIds);

    Optional<user> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}