package com.kunstNovi.repository;

import com.kunstNovi.model.role;
import com.kunstNovi.model.roleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<role, Long> {
    Optional<role> findByName(roleName roleName);
}
