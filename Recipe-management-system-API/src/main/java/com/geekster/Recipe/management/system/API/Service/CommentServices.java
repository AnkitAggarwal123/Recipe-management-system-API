package com.geekster.Recipe.management.system.API.Service;

import com.geekster.Recipe.management.system.API.Model.Comment;
import com.geekster.Recipe.management.system.API.Model.Recipe;
import com.geekster.Recipe.management.system.API.Model.User;
import com.geekster.Recipe.management.system.API.Repo.ICommentRepo;
import com.geekster.Recipe.management.system.API.Repo.IRecipeRepo;
import com.geekster.Recipe.management.system.API.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServices {

    @Autowired
    ICommentRepo commentRepo;

    @Autowired
    AuthenticationServices authenticationServices;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IRecipeRepo recipeRepo;

    public String addComment(String email, String tokenValue, String commentBody, Integer recipeId) {

        if(authenticationServices.authenticate(email, tokenValue)){
            User commenterUser = userRepo.findFirstByEmail(email);

            Recipe recipe = recipeRepo.findById(recipeId).orElseThrow();

            Comment comment = new Comment(null, commentBody, LocalDateTime.now(),recipe,commenterUser);
            commentRepo.save(comment);
            return comment.getCommenter().getName() + " commented on " + recipe.getName();
        }else{
            return "Invalid Credential";
        }

    }

    public String deleteComment(String email, String tokenValue, Integer commentId) {

        if(authenticationServices.authenticate(email,tokenValue)){
            Comment comment = commentRepo.findById(commentId).orElseThrow();

            if(comment.getCommenter().getEmail().equals(email)){
                commentRepo.deleteById(commentId);
                return "deleted successfully";
            }else{
                return "Invalid Credential";
            }

        }else{
            return "Invalid Credential";
        }
    }

    public String updateComment(String email, String tokenValue, Comment updatedComment) {

        if(authenticationServices.authenticate(email,tokenValue)){
            Comment comment = commentRepo.findById(updatedComment.getId()).orElseThrow();

            if(comment.getCommenter().getEmail().equals(email)){

                updatedComment.setCommenter(comment.getCommenter());
                updatedComment.setRecipe(comment.getRecipe());
                commentRepo.save(updatedComment);
                return "updated successfully";
            }else{
                return "Invalid credential";
            }

        }else {
            return "Invalid credential";
        }
    }



    public String getComment(String email, String tokenValue, Integer recipeId) {

        if(authenticationServices.authenticate(email,tokenValue)){
            Recipe recipe = recipeRepo.findById(recipeId).orElseThrow();
            List<Comment> comments = commentRepo.findByRecipe(recipe);
            for (Comment comment : comments){
                comment.getCommenter().setPassword(null);
            }
            return ""+comments;
        }else {
            return "un-authentication access";
        }
    }
}
