package com.fitness.activityservice.Service;

import com.fitness.activityservice.DTO.ActivityRequestDto;
import com.fitness.activityservice.DTO.ActivityResponseDto;

import java.util.List;

public interface ActivityService {

    ActivityResponseDto trackActivity(ActivityRequestDto request);

    List<ActivityResponseDto> getUserActivities(String userId);

    ActivityResponseDto getActivityById(String activityId);
}
