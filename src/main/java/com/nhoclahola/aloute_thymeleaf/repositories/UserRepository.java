package com.nhoclahola.aloute_thymeleaf.repositories;

import com.nhoclahola.aloute_thymeleaf.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{

}
