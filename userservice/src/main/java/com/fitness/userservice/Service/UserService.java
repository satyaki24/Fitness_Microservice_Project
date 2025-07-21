package com.fitness.userservice.Service;

import com.fitness.userservice.DTO.RegisterRequestDto;
import com.fitness.userservice.DTO.UserResponseDto;

public interface UserService {
    UserResponseDto getUserProfile(String userId);

    UserResponseDto register(RegisterRequestDto request);

    Boolean existByUserId(String userId);
}
