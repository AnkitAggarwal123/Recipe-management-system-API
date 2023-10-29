package com.geekster.Recipe.management.system.API.Controller;

import com.geekster.Recipe.management.system.API.Model.RegistrationDto;
import com.geekster.Recipe.management.system.API.Model.User;
import com.geekster.Recipe.management.system.API.Service.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {

    @Autowired
    UserServices userServices;


    @PostMapping("user/signUp")
    public String signUp(@RequestBody @Valid RegistrationDto registrationDto){
        return userServices.signUp(registrationDto);
    }

    @PostMapping("user/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password)
    {
        return userServices.userSignIn(email,password);
    }

    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestParam String email, @RequestParam String token)
    {
        return userServices.userSignOut(email,token);
    }

}
