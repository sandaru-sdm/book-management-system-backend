package com.sdm.bms.service;

import com.sdm.bms.dto.UserRequestDto;
import com.sdm.bms.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(UserRequestDto requestDto);
}
