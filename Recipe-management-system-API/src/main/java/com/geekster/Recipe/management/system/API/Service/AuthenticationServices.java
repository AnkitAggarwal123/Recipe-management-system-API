package com.geekster.Recipe.management.system.API.Service;

import com.geekster.Recipe.management.system.API.Model.Authentication;
import com.geekster.Recipe.management.system.API.Repo.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServices {

    @Autowired
    IAuthenticationRepo authenticationRepo;

    public void createToken(Authentication token) {
        authenticationRepo.save(token);

    }

    public Boolean authenticate(String email, String token){

        Authentication authentication = authenticationRepo.findFirstByTokenValue(token);

        if(authentication != null){
            return authentication.getUser().getEmail().equals(email);
        }else {
            return false;
        }
    }

    public void deleteToken(String tokenValue) {

        Authentication authentication = authenticationRepo.findFirstByTokenValue(tokenValue);

        authenticationRepo.delete(authentication);
    }
}
