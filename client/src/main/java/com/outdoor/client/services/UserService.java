package com.outdoor.client.services;

import com.outdoor.client.dto.IMapperDto;
import com.outdoor.client.dto.UserDto;
import com.outdoor.client.entities.UserEntity;
import com.outdoor.client.repository.UserRepository;
import com.outdoor.client.request.UserRequest;
import com.outdoor.client.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final IMapperDto<UserResponse, UserEntity> mapperUserDto;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void createUser(UserRequest userRequest){
        if(this.loadUserByEmail(userRequest.getEmail()) == null){
            UserEntity user = UserEntity.builder()
                    .firstname(userRequest.getFirstname())
                    .lastname(userRequest.getLastname())
                    .email(userRequest.getEmail())
                    .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                    .image(userRequest.getImage())
                    .role(userRequest.getRole())
                    .build();
            userRepository.save(user);
        }
    }

    public List<UserResponse> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponse> userResponses = mapperUserDto.convertListToListDto(users,UserResponse.class);
        return userResponses;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException( email + " not found");
        }
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public UserResponse loadUserByEmail(String email) {
        try{
            UserEntity user = userRepository.findByEmail(email);
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            return userResponse;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public UserResponse loadUserById(String id) {
        try{
            Optional<UserEntity> user = userRepository.findById(id);
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user.get(), userResponse);
            return userResponse;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public UserResponse updateUser(String id, UserDto userDto) {
        if(this.loadUserById(id) != null){
            UserEntity user = UserEntity.builder()
                    .id(id)
                    .firstname(userDto.getFirstname())
                    .lastname(userDto.getLastname())
                    .email(userDto.getEmail())
                    .password(bCryptPasswordEncoder.encode(userDto.getPassword()))
                    .image(userDto.getImage())
                    .role(userDto.getRole())
                    .build();
            userRepository.save(user);
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            return userResponse;
        }
        return null;
    }
}
