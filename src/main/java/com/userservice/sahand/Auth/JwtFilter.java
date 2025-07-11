package com.userservice.sahand.Auth;

import com.userservice.sahand.UserSession.UsersSession;
import com.userservice.sahand.Users.UsersService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Service
public class JwtFilter extends OncePerRequestFilter {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JwtFilter.class);
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsersSession usersSession;
    @Autowired
    private UsersService usersService;
    @Autowired
    UserDetailServiceImpl userDetailService;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        String jwt;
        String username;
        String uuid;
        String path = request.getServletPath();
        if (path.startsWith("/auth/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        uuid = jwtService.extractUUID(jwt);
        username = jwtService.extractUserName(jwt);
        try {
            Authentication authFromCache = usersSession.checkExist(uuid);
            if (authFromCache != null) {
                if(username.equals(authFromCache.getName())){
                SecurityContextHolder.getContext().setAuthentication(authFromCache);
                }
            }
            else{
                CustomUserDetail userDetail = (CustomUserDetail) userDetailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetail, null, userDetail.getAuthorities());
                authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
