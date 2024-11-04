package com.nhoclahola.aloute_thymeleaf.repositories;

import com.nhoclahola.aloute_thymeleaf.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    public abstract Optional<User> findByEmail(String email);

    public abstract boolean existsByEmail(String email);

    public abstract boolean existsByUsername(String username);
}
