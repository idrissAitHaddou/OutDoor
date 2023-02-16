package com.example.apigateway.security.filter;

import com.example.apigateway.security.config.JwtUtil;
import com.example.apigateway.users.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAutorisationFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public JwtAutorisationFilter(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException
    {
        final String authHeader = request.getHeader(JwtConstant.AUTORIZATION);
        final String userEmail;
        final String jwtToken;
        if(authHeader == null || !authHeader.startsWith(JwtConstant.BEARER)){
            filterChain.doFilter(request,response);
            return;
        }
        jwtToken = authHeader.substring(7);
        userEmail = jwtUtil.extractUsername(jwtToken);
        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userService.loadUserByUsername(userEmail);
            if(jwtUtil.isTokenValid(jwtToken, userDetails))
            {
                jwtUtil.registerAuthenticationTokenInContext(userDetails, request);
            }
        }
        filterChain.doFilter(request,response);
    }
}
