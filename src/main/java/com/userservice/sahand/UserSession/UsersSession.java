package com.userservice.sahand.UserSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Cache;

import java.util.concurrent.TimeUnit;

@Service
public class UsersSession implements UserSessionInterface {
    private final static  Cache<String, Principal> cachePrincipal =
            CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();
    private final static  Cache<String,Authentication> cacheAuthentication =
            CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();

    @Override
    public boolean saveToCachePrincipal(String uuid, Principal principal) throws Exception {
        try {
            cachePrincipal.put(uuid,principal);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean saveToCacheSession(String uuid, Authentication authentication) throws Exception {
        try {
            cacheAuthentication.put(uuid, authentication);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Principal checkExistUserSession(String uuid) {
        return cachePrincipal.getIfPresent(uuid);
    }
    @Override
    public Authentication checkExist(String uuid) {
        return cacheAuthentication.getIfPresent(uuid);

    }

}
