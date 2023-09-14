package com.durys.jakub.engagementservice.engagement.domain;

import java.time.LocalDate;

public record Engagement(Long id, Long userId, LocalDate from, LocalDate to) {
}
