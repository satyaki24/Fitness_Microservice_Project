package com.fitness.gateway.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password size must be >=6")
    private String password;

    private String keycloakId;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String lastName;
}
