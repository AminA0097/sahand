package com.userservice.sahand.UserSession;

import org.springframework.security.core.Authentication;

import java.util.Map;

public interface UserSessionInterface {
    public boolean saveToCachePrincipal(String uuid, Authentication authentication) throws Exception;
    public boolean saveToCacheSession(String uuid,UserSessionSimple userSessionSimple) throws Exception;

    public Authentication checkExist(String uuid)throws Exception;
}
