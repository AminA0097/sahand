package com.userservice.sahand.UserSession;

import org.springframework.security.core.Authentication;

public interface UserSessionInterface {
    public boolean saveToCachePrincipal(String uuid, Principal principal) throws Exception;
    public boolean saveToCacheSession(String uuid, Authentication authentication) throws Exception;
    public Authentication checkExist(String uuid);
    public Principal checkExistUserSession(String uuid);
}
