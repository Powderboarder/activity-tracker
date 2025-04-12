package com.example.activity.achievements.personal.recurring;

import java.time.Duration;
import java.time.ZonedDateTime;

public class TotalTimeAchievement {

    /**
     * Get the total time possible in range in minutes.
     * @param fromDate
     * @param toDate
     * @return
     */
    public long getTotalTime(final ZonedDateTime fromDate, final ZonedDateTime toDate) throws Exception{
        Duration duration = Duration.between(fromDate, toDate);

        return duration.toMinutes();
    }
}
