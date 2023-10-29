package com.geekster.Recipe.management.system.API.Repo;

import com.geekster.Recipe.management.system.API.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepo extends JpaRepository<Recipe, Integer> {
}
