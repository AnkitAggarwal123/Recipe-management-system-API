package com.geekster.Recipe.management.system.API.Repo;

import com.geekster.Recipe.management.system.API.Model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<Authentication, Long> {
    Authentication findFirstByTokenValue(String token);
}
