package com.fitness.userservice.Service;

import com.fitness.userservice.DTO.RegisterRequestDto;
import com.fitness.userservice.DTO.UserResponseDto;
import com.fitness.userservice.Entity.User;
import com.fitness.userservice.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDto getUserProfile(String userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User does not exist with Id: " + userId));

        UserResponseDto userResponseDto=new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setCreatedAt(user.getCreatedAt());
        userResponseDto.setUpdatedAt(user.getUpdatedAt());

        return userResponseDto;
    }

    @Override
    public UserResponseDto register(RegisterRequestDto request) {

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Account already exists with email " + request.getEmail());
        }

        User user=new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUser= userRepository.save(user);

        UserResponseDto userResponseDto=new UserResponseDto();

        userResponseDto.setId(savedUser.getId());
        userResponseDto.setEmail(savedUser.getEmail());
        userResponseDto.setPassword(savedUser.getPassword());
        userResponseDto.setFirstName(savedUser.getFirstName());
        userResponseDto.setLastName(savedUser.getLastName());
        userResponseDto.setCreatedAt(savedUser.getCreatedAt());
        userResponseDto.setUpdatedAt(savedUser.getUpdatedAt());

        return userResponseDto;
    }

    @Override
    public Boolean existByUserId(String userId) {
        log.info("Calling User Validation API for User with Id: {}", userId);
        return userRepository.existsById(userId);
    }
}
