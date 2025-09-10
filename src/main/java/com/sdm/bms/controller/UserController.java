package com.sdm.bms.controller;

import com.sdm.bms.dto.BookRequestDto;
import com.sdm.bms.dto.BookResponseDto;
import com.sdm.bms.dto.UserRequestDto;
import com.sdm.bms.dto.UserResponseDto;
import com.sdm.bms.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto requestDto) {
        UserResponseDto userResponseDto = userService.createUser(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto requestDto) {
        UserResponseDto updatedUser = userService.updateUser(id, requestDto);
        return ResponseEntity.ok().body(updatedUser);
    }
}
