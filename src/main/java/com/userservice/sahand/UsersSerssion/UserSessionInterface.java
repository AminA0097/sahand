package com.userservice.sahand.UsersSerssion;

import org.springframework.security.core.Authentication;

public interface UserSessionInterface {
    public boolean saveToCachePrincipal(String uuid, PrincipalSimple principal) throws Exception;

    public boolean saveToCacheAuth(String uuid, Authentication authentication) throws Exception;

    public Authentication checkExist(String uuid);

    public PrincipalSimple checkExistUserSession(String uuid);

    public String getUuid() throws Exception;

    public boolean checkAccess(PrincipalSimple principalSimple, long actionId) throws Exception;
}
