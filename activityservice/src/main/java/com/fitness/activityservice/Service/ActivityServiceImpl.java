package com.fitness.activityservice.Service;

import com.fitness.activityservice.DTO.ActivityRequestDto;
import com.fitness.activityservice.DTO.ActivityResponseDto;
import com.fitness.activityservice.Entity.Activity;
import com.fitness.activityservice.Repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{

    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;

    @Override
    public ActivityResponseDto trackActivity(ActivityRequestDto request) {

        boolean isValidUser= userValidationService.validateUser(request.getUserId());

        if(!isValidUser){
            throw new RuntimeException("Invalid user with Id: "+ request.getUserId());
        }

        Activity activity=Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurnt(request.getCaloriesBurnt())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity=activityRepository.save(activity);

        return mapToResponse(savedActivity);
    }

    @Override
    public List<ActivityResponseDto> getUserActivities(String userId) {
        List<Activity> activities= activityRepository.findByUserId(userId);

        return activities.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityResponseDto getActivityById(String activityId) {
        return activityRepository.findById(activityId)
                .map(this::mapToResponse)
                .orElseThrow(()-> new RuntimeException("Activity not Found with Id: " + activityId));
    }

    private ActivityResponseDto mapToResponse(Activity activity){
        ActivityResponseDto activityResponseDto=new ActivityResponseDto();
        activityResponseDto.setId(activity.getId());
        activityResponseDto.setType(activity.getType());
        activityResponseDto.setUserId(activity.getUserId());
        activityResponseDto.setDuration(activity.getDuration());
        activityResponseDto.setCaloriesBurnt(activity.getCaloriesBurnt());
        activityResponseDto.setStartTime(activity.getStartTime());
        activityResponseDto.setAdditionalMetrics(activity.getAdditionalMetrics());
        activityResponseDto.setCreatedAt(activity.getCreatedAt());
        activityResponseDto.setUpdatedAt(activity.getUpdatedAt());

        return activityResponseDto;
    }
}
