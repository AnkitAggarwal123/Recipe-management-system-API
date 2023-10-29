package com.geekster.Recipe.management.system.API.Repo;

import com.geekster.Recipe.management.system.API.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findFirstByEmail(String newEmail);
}
