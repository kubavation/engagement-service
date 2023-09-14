package com.durys.jakub.engagementservice.engagement.infrastructure.in;

import com.durys.jakub.engagementservice.engagement.domain.Engagement;
import com.durys.jakub.engagementservice.engagement.domain.EngagementRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Profile("test")
public class TestEngagementRepository implements EngagementRepository {


    @Override
    public List<Engagement> userEngagements(Long userId) {
        return Collections.emptyList();
    }

    @Override
    public Engagement engagementById(Long id) {
        return null;
    }
}
