package com.sdm.bms.service;

import com.sdm.bms.dto.UserRequestDto;
import com.sdm.bms.dto.UserResponseDto;
import com.sdm.bms.entity.UserEntity;
import com.sdm.bms.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
       if(userRepository.existsByEmail(requestDto.getEmail())) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
       }

       UserEntity newUser = convertToUserEntity(requestDto);
       newUser = userRepository.save(newUser);
       return convertToUserResponse(newUser);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(this::convertToUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found for id: " + id));
        return convertToUserResponse(user);
    }

    private UserResponseDto convertToUserResponse(UserEntity newUser) {
        return UserResponseDto.builder()
                .id(newUser.getId())
                .name(newUser.getName())
                .email(newUser.getEmail())
                .build();
    }

    private UserEntity convertToUserEntity(UserRequestDto userRequestDto) {
        return UserEntity.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .build();
    }
}
