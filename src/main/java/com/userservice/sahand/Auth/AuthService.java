package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.UserSession.UserSessionSimple;
import com.userservice.sahand.UserSession.UsersSession;
import com.userservice.sahand.Users.UsersEntity;
import com.userservice.sahand.Users.UsersForm;
import com.userservice.sahand.Users.UsersInterface;
import com.userservice.sahand.Users.UsersService;
import com.userservice.sahand.Utils.Remote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService implements AuthInterface{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersService usersService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    UsersSession usersSession;
    @Override
    public String login(LoginForm loginForm) throws Exception{
        UsersInterface usersInterface = (UsersInterface) Remote.makeRemote(UsersInterface.class);
        authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        UsersEntity users = usersInterface.findUsername(loginForm.getUsername());
        if(users == null){
            return null;
        }
        UserSessionSimple userSessionSimple = new UserSessionSimple(users);
        String uuid = UUID.randomUUID().toString();
        return jwtService.generateToken(new CustomUserDetail(users),uuid);
    }

    @Override
    public String signUp(UsersForm usersForm) throws Exception {
//        SubmitUser
        String userId =  usersService.userRegistration(usersForm);
        if(userId == null || userId.equals("-1")){
            throw new Exception("User registration failed");
            return "failed";
        }
//        GenerateJWT
        String uuid = UUID.randomUUID().toString();
        UsersEntity users = (UsersEntity) usersService.find(" e.userId = "+ userId);
        String token =  jwtService.generateToken(new CustomUserDetail(users),uuid);
//        FillUserSession
    }
}
