package com.userservice.sahand.UserSession;

import com.userservice.sahand.Users.UsersEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Cache;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UsersSession implements UserSessionInterface {
    private final static  Cache<String,UserSessionSimple> cacheSession =
            CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();
    private final static  Cache<String,Authentication> cachePrincipal =
            CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();

    @Override
    public boolean saveToCachePrincipal(String uuid, Authentication authentication) throws Exception {
        try {
            cachePrincipal.put(uuid,authentication);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean saveToCacheSession(String uuid, UserSessionSimple userSessionSimple) throws Exception {
        try {
            cacheSession.put(uuid,userSessionSimple);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Authentication checkExist(String uuid) throws Exception {
        return cachePrincipal.getIfPresent(uuid);
    }

}
