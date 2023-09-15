package com.durys.jakub.engagementservice.engagement.infrastructure.in;

import com.durys.jakub.engagementservice.engagement.domain.Engagement;
import com.durys.jakub.engagementservice.engagement.domain.EngagementRepository;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class TestEngagementRepository implements EngagementRepository {

    private static final Set<Engagement> DB = Set.of(
            new Engagement(1L, 1L, LocalDate.now(), LocalDate.now().plusYears(1)),
            new Engagement(2L, 2L, LocalDate.now(), LocalDate.now().plusYears(1)),
            new Engagement(3L, 1L, LocalDate.now(), LocalDate.now().plusYears(1))
    );

    @Override
    public List<Engagement> userEngagements(Long userId) {
        return DB.stream()
                .filter(engagement -> engagement.userId().equals(userId))
                .toList();
    }

    @Override
    public Engagement engagementById(Long id) {
        return DB.stream()
                .filter(engagement -> engagement.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
