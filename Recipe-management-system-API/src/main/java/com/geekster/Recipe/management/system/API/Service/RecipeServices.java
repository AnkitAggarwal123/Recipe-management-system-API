package com.geekster.Recipe.management.system.API.Service;

import com.geekster.Recipe.management.system.API.Model.Comment;
import com.geekster.Recipe.management.system.API.Model.Recipe;
import com.geekster.Recipe.management.system.API.Model.User;
import com.geekster.Recipe.management.system.API.Repo.ICommentRepo;
import com.geekster.Recipe.management.system.API.Repo.IRecipeRepo;
import com.geekster.Recipe.management.system.API.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServices {

    @Autowired
    IRecipeRepo recipeRepo;

    @Autowired
    AuthenticationServices authenticationServices;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    ICommentRepo commentRepo;
    public String addRecipe(Recipe recipe, String email, String tokenValue) {

        if(authenticationServices.authenticate(email, tokenValue)){
            User user = userRepo.findFirstByEmail(email);
            recipe.setUser(user);
            recipeRepo.save(recipe);
            return "Added Successfully";

        }else {

            return "Invalid Credential";

        }


    }

    public String updateRecipeInfo(Recipe recipe, String email, String tokenValue) {

        if(authenticationServices.authenticate(email, tokenValue)){
            Integer id = recipe.getId();

            Recipe existingRecipe = recipeRepo.findById(id).orElse(null);

            if(existingRecipe == null){
                return "this recipe is not exist";
            }

            if(existingRecipe.getUser().getEmail().equals(email)){
                recipe.setUser(existingRecipe.getUser());
                recipeRepo.save(recipe);
                return "updated successfully";
            }else{
                return "Invalid Credential";
            }


        }else{
            return "Invalid Credential";
        }
    }

    public String deleteRecipe(Integer recipeId, String email, String tokenValue) {

        if(authenticationServices.authenticate(email, tokenValue)){
            Recipe recipe = recipeRepo.findById(recipeId).orElseThrow();


            if(recipe.getUser().getEmail().equals(email)){
                List<Comment> comment = commentRepo.findByRecipe(recipe);
                if(comment != null){
                    commentRepo.deleteAll(comment);
                }
                recipeRepo.deleteById(recipeId);
                return "deleted successfully";
            }else {
                return "Invalid Credential";
            }
        }else {
            return "Un-authentication error";
        }
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes =  recipeRepo.findAll();

        for(Recipe res : recipes){
            User user = res.getUser();
            user.setPassword(null);
        }

        return recipes;
    }

    public String getByID(Integer recipeId, String email, String tokenValue) {

        if(authenticationServices.authenticate(email, tokenValue)){
            Recipe recipe = recipeRepo.findById(recipeId).orElseThrow();
            recipe.getUser().setPassword(null);
            return ""+recipe;
        }else {
            return "un-authentication access";
        }
    }
}
