package com.outdoor.client.services;

import com.outdoor.client.dto.IMapperDto;
import com.outdoor.client.entities.User;
import com.outdoor.client.repository.UserRepository;
import com.outdoor.client.request.UserRequest;
import com.outdoor.client.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final IMapperDto<UserResponse, User> mapperUserDto;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void createUser(UserRequest userRequest) throws Exception{
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new Exception("User already exists");
        }
        User user = mapperUserDto.convertToEntity(UserResponse.builder().build(), User.class);
        if (user != null) {
            user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
            userRepository.save(user);
        } else {
            throw new Exception("User not found");
        }
    }
}
