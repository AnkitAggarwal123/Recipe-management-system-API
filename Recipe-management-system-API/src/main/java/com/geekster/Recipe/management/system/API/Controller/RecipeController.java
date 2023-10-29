package com.geekster.Recipe.management.system.API.Controller;

import com.geekster.Recipe.management.system.API.Model.Recipe;
import com.geekster.Recipe.management.system.API.Service.RecipeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeServices recipeServices;

    @PostMapping("Recipe")
    public String addRecipe(@RequestBody Recipe recipe, @RequestParam String email, @RequestParam String tokenValue){
        return recipeServices.addRecipe(recipe, email, tokenValue);
    }

    @PutMapping("Recipe")
    public String updateRecipeInfo(@RequestBody Recipe recipe, @RequestParam String email, @RequestParam String tokenValue){
        return recipeServices.updateRecipeInfo(recipe, email, tokenValue);
    }

    @DeleteMapping("Recipe")
    public String deleteRecipe(@RequestParam Integer recipeId, @RequestParam String email, @RequestParam String tokenValue){
        return recipeServices.deleteRecipe(recipeId, email, tokenValue);
    }

    @GetMapping("recipe/all")
    public List<Recipe> getAllRecipes(){
        return recipeServices.getAllRecipes();
    }

    @GetMapping("recipe/id")
    public String getById(@RequestParam Integer recipeId, @RequestParam String email, @RequestParam String tokenValue){
        return recipeServices.getByID(recipeId, email, tokenValue);
    }

}
