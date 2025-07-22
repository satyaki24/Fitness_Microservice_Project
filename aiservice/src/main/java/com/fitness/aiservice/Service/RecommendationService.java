package com.fitness.aiservice.Service;


import com.fitness.aiservice.Entity.Recommendation;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getUserRecommendation(String userId);

    Recommendation getActivityRecommendation(String activityId);
}
