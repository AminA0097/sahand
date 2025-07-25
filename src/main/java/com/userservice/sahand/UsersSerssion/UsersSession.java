package com.userservice.sahand.UsersSerssion;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.userservice.sahand.Auth.CustomUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UsersSession implements UserSessionInterface {
    private final static Cache<String, PrincipalSimple> cachePrincipal =
            CacheBuilder.newBuilder().expireAfterAccess(15, TimeUnit.MINUTES).build();
    private final static Cache<String, Authentication> cacheAuthentication =
            CacheBuilder.newBuilder().expireAfterAccess(15, TimeUnit.MINUTES).build();

    @Override
    public boolean saveToCachePrincipal(String uuid, PrincipalSimple principal) throws Exception {
        try {
            cachePrincipal.put(uuid, principal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean saveToCacheAuth(String uuid, Authentication authentication) throws Exception {
        try {
            cacheAuthentication.put(uuid, authentication);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PrincipalSimple checkExistUserSession(String uuid) {
        return cachePrincipal.getIfPresent(uuid);
    }

    @Override
    public Authentication checkExist(String uuid) {
        return cacheAuthentication.getIfPresent(uuid);

    }

    @Override
    public String getUuid() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !(auth.getPrincipal() instanceof CustomUserDetail)) {
            throw new Exception("Invalid authentication");
        }
        return ((CustomUserDetail) auth.getPrincipal()).getUuid();
    }

    @Override
    public boolean checkAccess(PrincipalSimple principalSimple, long actionId) throws Exception {
//        Set<ActionsEntity> userActions = principalSimple.getActions();
//        for (ActionsEntity action : userActions) {
//            if (action.getId() == actionId) {
//                return true;
//            }
//        }
//        throw new Exception("Invalid action");
//    }
        return false;
    }
}
