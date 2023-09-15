package com.durys.jakub.engagementservice.engagement.domain;

import java.util.List;

public interface EngagementRepository {
    List<Engagement> userEngagements(Long userId);
    Engagement engagementById(Long id);
}
