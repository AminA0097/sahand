package com.userservice.sahand.Auth;

import com.userservice.sahand.UserSession.UsersSession;
import com.userservice.sahand.Users.UsersService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
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
        final String jwt;
        final String uuid;
        final String userName;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        uuid = jwtService.extractUUID(jwt);
        userName = jwtService.extractUserName(jwt);
        if (uuid != null && userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                Authentication authentication = usersSession.checkExist(uuid);
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    CustomUserDetail userDetail = (CustomUserDetail) userDetailService
                            .getUserDetailsService().loadUserByUsername(userName);

                    if(jwtService.validationToken(jwt,userDetail)){
                        UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(
                                userDetail, null, userDetail.getAuthorities());
                        newAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        usersSession.saveToCachePrincipal(uuid, newAuthentication);
                        SecurityContextHolder.getContext().setAuthentication(newAuthentication);
                    }
                }
            } catch (Exception e) {
                log.error("JWT filter error: {}", e.getMessage(), e);
            }
        }

        filterChain.doFilter(request, response);
    }
}
