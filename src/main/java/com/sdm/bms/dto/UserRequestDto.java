package com.sdm.bms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotNull(message = "Name is mandatory")
    @NotBlank
    private String name;
    @NotNull(message = "Email is mandatory")
    @NotBlank
    private String email;
    @NotNull(message = "Password is mandatory")
    @NotBlank
    private String password;
}
