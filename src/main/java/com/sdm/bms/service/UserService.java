package com.sdm.bms.service;

import com.sdm.bms.dto.UserRequestDto;
import com.sdm.bms.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto requestDto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(Long id);

    UserResponseDto updateUser(Long id, UserRequestDto requestDto);

    void deleteUser(Long id);

    List<UserResponseDto> getAllActiveUsers();
}
