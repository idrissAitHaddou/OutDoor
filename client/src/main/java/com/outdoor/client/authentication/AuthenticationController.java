package com.outdoor.client.authentication;

import com.outdoor.client.dto.UserDto;
import com.outdoor.client.request.UserAuthRequest;
import com.outdoor.client.security.config.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid UserAuthRequest userRequest) throws IOException {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);
        return authenticationService.signIn(userDto);
    }

    @PostMapping("/check-token")
    public ResponseEntity<Boolean> createAuthenticationToken(@RequestBody String token) throws IOException {
        try {
            Boolean expired = !jwtUtil.isTokenExpired(token);
            System.out.println(expired);
            return ResponseEntity.ok(expired);
        }catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }

}
