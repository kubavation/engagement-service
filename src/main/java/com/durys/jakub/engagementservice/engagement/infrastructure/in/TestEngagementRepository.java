package com.durys.jakub.engagementservice.engagement.infrastructure.in;

import com.durys.jakub.engagementservice.engagement.domain.Engagement;
import com.durys.jakub.engagementservice.engagement.domain.EngagementRepository;

import java.util.Collections;
import java.util.List;

class TestEngagementRepository implements EngagementRepository {

    //todo mock

    @Override
    public List<Engagement> userEngagements(Long userId) {
        return Collections.emptyList();
    }

    @Override
    public Engagement engagementById(Long id) {
        return null;
    }
}
