package com.example.activity.testRepository;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.activity.beans.Activity;
import com.example.activity.enums.ActivityDistanceEnum;
import com.example.activity.enums.ActivityTypeEnum;

@Configuration
public class LoadDatabase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ActivityRepository activityRepository) {
        return args -> {
            LOGGER.info("Preloading " + activityRepository.save(new Activity(Long.valueOf(1), new Date(),
                    ActivityTypeEnum.WALK, Integer.valueOf(30), BigDecimal.valueOf(1), ActivityDistanceEnum.MILES)));
            LOGGER.info("Preloading " + activityRepository.save(new Activity(Long.valueOf(1), new Date(),
                    ActivityTypeEnum.WALK, Integer.valueOf(45), BigDecimal.valueOf(1.5), ActivityDistanceEnum.MILES)));
            LOGGER.info("Preloading " + activityRepository.save(new Activity(Long.valueOf(2), new Date(),
                    ActivityTypeEnum.WALK, Integer.valueOf(30), BigDecimal.valueOf(1), ActivityDistanceEnum.METERS)));
        };
    }
}
