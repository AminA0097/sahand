package com.userservice.sahand.Jwt;

import com.userservice.sahand.Auth.UserDetailServiceImpl;
import com.userservice.sahand.Users.UsersService;
import com.userservice.sahand.UsersSerssion.UsersSession;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        System.out.println(path);
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
                SecurityContextHolder.getContext().setAuthentication(authFromCache);
            } else {
                log.error("Session Not Found!");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
//            else{
//                CustomUserDetail userDetail = (CustomUserDetail) userDetailService.loadUserByUsername(username);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                        userDetail, null, userDetail.getAuthorities());
//                authentication.setDetails(
//                        new WebAuthenticationDetailsSource().buildDetails(request)
//                );
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
