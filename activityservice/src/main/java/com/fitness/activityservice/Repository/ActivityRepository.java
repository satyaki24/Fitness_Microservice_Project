package com.fitness.activityservice.Repository;

import com.fitness.activityservice.Entity.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity, String > {
    List<Activity> findByUserId(String userId);
}
