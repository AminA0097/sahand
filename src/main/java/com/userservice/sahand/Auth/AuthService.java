package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Persons.PersonsInterface;
import com.userservice.sahand.UserSession.UserSessionInterface;
import com.userservice.sahand.UserSession.Principal;
import com.userservice.sahand.Users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService implements AuthInterface{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersInterface usersService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    UserSessionInterface usersSession;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PersonsInterface personsInterface;

    @Override
    public String login(LoginForm loginForm) throws Exception{
        Authentication authentication =  authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        UsersEntity users = usersService.findUsername(loginForm.getUsername());
        if(users == null){
            return null;
        }
        String uuid = UUID.randomUUID().toString();
        String token = jwtService.generateToken(new CustomUserDetail(users),uuid);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Principal principal = new Principal(users);
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
        userDetail.setUuid(uuid);

        return token;

    }

    @Override
    public String signUp(UsersForm usersForm) throws Exception {
//        SubmitUser
        usersForm.setPassword(passwordEncoder.encode(usersForm.getPassword()));
        String userId =  usersService.userRegistration(usersForm);
        if(userId == null || userId.equals("-1")){
            return "failed to register user";
        }
//        GenerateJWT
        String uuid = UUID.randomUUID().toString();
        UsersEntity users = (UsersEntity) usersService.find(" e.userId = "+ userId);
        String token =  jwtService.generateToken(new CustomUserDetail(users),uuid);
        if(token == null || token.equals("")){
            return "failed to return token";
        }
        return token;
    }

    @Override
    public String signUpPersons(PersonsForm personsForm) throws Exception {
        if(personsForm.getId() == -1){
            PersonsEntity personsEntity = (PersonsEntity) personsInterface.find(" e.nationalNumber= '" + personsForm.getNationalNumber() + "'");
            if(personsEntity == null){
                personsForm.setPersonId(null);
            }
            return "failed to register person";
        }
        return personsInterface.save(personsForm);
    }
}
