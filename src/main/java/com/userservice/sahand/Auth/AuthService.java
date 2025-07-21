package com.userservice.sahand.Auth;

import com.userservice.sahand.Jwt.JwtService;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Persons.PersonsInterface;
import com.userservice.sahand.Users.UsersEntity;
import com.userservice.sahand.Users.UsersForm;
import com.userservice.sahand.Users.UsersInterface;
import com.userservice.sahand.UsersSerssion.PrincipalSimple;
import com.userservice.sahand.UsersSerssion.UserSessionInterface;
import com.userservice.sahand.Utils.FilterRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthService implements AuthInterface {
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
    @Autowired
    UserDetailServiceImpl userDetailService;

    @Override
    public String login(LoginForm loginForm, HttpServletResponse res) throws Exception {
        Authentication authentication;
        String token;
        try {
            authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        } catch (BadCredentialsException e) {
            return "";
        } catch (AuthenticationException e) {
            return "";
        }
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
        String uuid = UUID.randomUUID().toString();
        customUserDetail.setUuid(uuid);

        UsersEntity users = (UsersEntity) usersService.find("userName = 'admin' and deleted = false and enabled = true");
        Authentication updatedAuthentication = new UsernamePasswordAuthenticationToken(
                customUserDetail,
                authentication.getCredentials(),
                customUserDetail.getAuthorities()
        );
        usersSession.saveToCacheAuth(uuid, updatedAuthentication);
        usersSession.saveToCachePrincipal(uuid, new PrincipalSimple(users));
        try {
            token = jwtService.generateToken(customUserDetail, uuid);
            return token;
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public String signUpUsers(UsersForm usersForm) throws Exception {
//        SubmitUser
        usersForm.setPassword(passwordEncoder.encode(usersForm.getPassword()));
        String userId = usersService.userRegistration(usersForm);
        if (userId == null || userId.equals("user already exists")) {
            return "failed";
        }
//        GenerateJWT
        String uuid = UUID.randomUUID().toString();
        UsersEntity users = (UsersEntity) usersService.find(" e.userId = " + userId);
        String token = jwtService.generateToken(new CustomUserDetail(), uuid);
        if (token == null || token.equals("")) {
            return "failed";
        }
        return token;
    }

    @Override
    public String signUpPersons(PersonsForm personsForm) throws Exception {
        if (personsForm.getId() == -1) {
            PersonsEntity personsEntity = (PersonsEntity) personsInterface.find(" e.nationalNumber= '" + personsForm.getNationalNumber() + "'");
            if (personsEntity == null) {
                personsForm.setPersonId(null);
            } else {
                return "failed";
            }
        }
        String id = personsInterface.save(personsForm);
        if (id == null || id.equals("-1")) {
            return "failed";
        }
        return id;
    }

    @Override
    public List getUsersInfo(FilterRequest filterRequest) throws Exception {
        return usersService.getList(filterRequest);
    }

    @Override
    public boolean verifyToken(VerifyToken verifyToken) throws Exception {
        return false;
    }
}
