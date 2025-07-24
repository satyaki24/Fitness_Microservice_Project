package com.fitness.aiservice.Service;

import com.fitness.aiservice.Entity.Activity;

public interface ActivityMessageListener {
    void processActivity(Activity activity);
}
