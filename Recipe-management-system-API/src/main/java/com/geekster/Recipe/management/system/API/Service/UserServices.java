package com.geekster.Recipe.management.system.API.Service;

import com.geekster.Recipe.management.system.API.Model.Authentication;
import com.geekster.Recipe.management.system.API.Model.RegistrationDto;
import com.geekster.Recipe.management.system.API.Model.User;
import com.geekster.Recipe.management.system.API.Repo.IUserRepo;
import com.geekster.Recipe.management.system.API.Service.HashingUtility.PasswordEncryptor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServices {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationServices authenticationServices;
    @SneakyThrows
    public String signUp(RegistrationDto registrationDto) {

        String newEmail = registrationDto.getEmail();

        User existingUser = userRepo.findFirstByEmail(newEmail);

        if(existingUser != null)
        {
            return "email already in use";
        }

        // passwords are encrypted before we store it in the table

        String signUpPassword = registrationDto.getPassword();


            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            User user=new User(null,registrationDto.getName(), registrationDto.getEmail(),encryptedPassword);


            // patient table - save patient
            userRepo.save(user);
            return "user registered";



    }
    public String userSignIn(String email, String password) {

        User existingUser = userRepo.findFirstByEmail(email);

        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if(existingUser.getPassword().equals(encryptedPassword))
            {
                Authentication token  = new Authentication(existingUser);
                    authenticationServices.createToken(token);
                    return "Token Value" + " = " +token.getTokenValue();
            }
            else {
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignOut(String email, String tokenValue) {
        if(authenticationServices.authenticate(email,tokenValue)) {
            authenticationServices.deleteToken(tokenValue);
            return "Sign Out successful!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }
}
