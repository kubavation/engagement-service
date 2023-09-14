package com.durys.jakub.engagementservice.engagement.infrastructure.in;

import com.durys.jakub.engagementservice.engagement.domain.EngagementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
class EngagementConfiguration {

    @Bean
    @Primary
    EngagementRepository engagementRepository() {
        log.info("creating prod engagement repository");
        return new PostgresEngagementRepository();
    }

    @Bean
    @Profile("test")
    EngagementRepository testEngagementRepository() {
        log.info("creating test engagement repository");
        return new TestEngagementRepository();
    }


}
