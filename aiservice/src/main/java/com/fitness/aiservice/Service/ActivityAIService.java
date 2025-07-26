package com.fitness.aiservice.Service;

import com.fitness.aiservice.Entity.Activity;
import com.fitness.aiservice.Entity.Recommendation;

public interface ActivityAIService {
    Recommendation generateRecommendation(Activity activity);
}
