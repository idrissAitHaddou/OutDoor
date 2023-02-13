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

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final IMapperDto<UserResponse, User> mapperUserDto;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void createUser(UserRequest userRequest){
        User user = User.builder()
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .image(userRequest.getImage())
                .role(userRequest.getRole())
                .build();
        userRepository.save(user);
        log.info("User {} is saved", user.getId_user());

    }

    public List<UserResponse> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = mapperUserDto.convertListToListDto(users,UserResponse.class);
        return userResponses;
    }
}
