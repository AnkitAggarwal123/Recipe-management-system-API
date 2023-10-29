package com.geekster.Recipe.management.system.API.Controller;

import com.geekster.Recipe.management.system.API.Model.Comment;
import com.geekster.Recipe.management.system.API.Service.CommentServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    CommentServices commentServices;

    @PostMapping("comment/recipeId")
    public String addComment(@RequestParam String email, @RequestParam String tokenValue, @RequestBody String commentBody, @RequestParam Integer recipeId){
        return commentServices.addComment(email,tokenValue,commentBody,recipeId);
    }

    @DeleteMapping("comment")
    public String deleteComment(@RequestParam String email, @RequestParam String tokenValue,@RequestParam Integer commentId){
        return  commentServices.deleteComment(email,tokenValue,commentId);
    }

    @PutMapping("comment")
    public String updateComment(@RequestParam String email, @RequestParam String tokenValue, @RequestBody Comment comment){
        return commentServices.updateComment(email,tokenValue,comment);
    }

    @GetMapping("comment/{recipeId}")
    public String getComment(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Integer recipeId){
        return commentServices.getComment(email,tokenValue,recipeId);
    }

}
