package com.fitness.userservice.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDto {
    private String Id;
    private String keycloakId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
