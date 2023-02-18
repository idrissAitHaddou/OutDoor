package com.outdoor.order.security.filter;

import com.outdoor.order.feign.UserFeign;
import com.outdoor.order.objects.User;
import com.outdoor.order.security.config.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@RequiredArgsConstructor
@Component
public class JwtAutorisationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserFeign userFeign;

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
            User user = userFeign.getUserByEmail(userEmail);
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());;
            if(jwtUtil.isTokenValid(jwtToken, userDetails))
            {
                jwtUtil.registerAuthenticationTokenInContext(userDetails, request);
            }
        }
        filterChain.doFilter(request,response);
    }
}
