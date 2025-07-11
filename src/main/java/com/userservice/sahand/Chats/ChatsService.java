package com.userservice.sahand.Chats;

import com.userservice.sahand.Auth.JwtService;
import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.Bases.BasesService;
import com.userservice.sahand.UserSession.PrincipalSimple;
import com.userservice.sahand.UserSession.UserSessionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ChatsService extends BasesService<ChatsEntity> implements ChatsInterface {
    @Autowired
    UserSessionInterface userSessionInterface;
    @Autowired
    JwtService jwtService;
    @Override
    public boolean addChat() throws Exception {
        String uuid = userSessionInterface.getUuid();
        PrincipalSimple principalSimple = userSessionInterface.checkExistUserSession(uuid);
        return false;
    }
}
