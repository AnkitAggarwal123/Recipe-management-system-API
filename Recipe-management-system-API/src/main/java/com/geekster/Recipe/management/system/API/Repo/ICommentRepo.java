package com.geekster.Recipe.management.system.API.Repo;

import com.geekster.Recipe.management.system.API.Model.Comment;
import com.geekster.Recipe.management.system.API.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findByRecipe(Recipe recipe);
}
