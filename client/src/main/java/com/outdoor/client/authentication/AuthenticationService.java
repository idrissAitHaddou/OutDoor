package com.outdoor.client.authentication;

import com.outdoor.client.dto.UserDto;
import com.outdoor.client.security.config.JwtUtil;
import com.outdoor.client.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> signIn(UserDto userDto){
        try {
            Map<String, Object> responseToken = new HashMap<>();
            final UserDetails user = userService.loadUserByUsername(userDto.getEmail());
            if(user != null) {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword())
                );
                UserDto userInfo = new UserDto();
                BeanUtils.copyProperties(userService.loadUserByEmail(userDto.getEmail()), userInfo);
                responseToken.put("accessToken", jwtUtil.generateToken(user));
                responseToken.put("user", userInfo);
                return ResponseEntity.ok(responseToken);
            }
            responseToken.put("accessToken", null);
            responseToken.put("user", null);
            return ResponseEntity.status(400).body(responseToken);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.ok("login faild ");
        }
    }

}
