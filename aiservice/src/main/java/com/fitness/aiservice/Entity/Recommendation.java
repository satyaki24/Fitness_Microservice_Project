package com.fitness.aiservice.Entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "recommendations")
@Data
@Builder
public class Recommendation {
    @Id
    private String id;
    private String activityId;
    private String userId;
    private String ActivityType;
    private String recommendation;
    private List<String> improvements;
    private String suggestions;
    private String safety;
    @CreatedDate
    private LocalDateTime createdAt;
}
