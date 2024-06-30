package com.example.activity.testRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.activity.beans.Activity;

import java.util.Date;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByActivityUserId(final Long activityUserId);

    @Query("select activity from Activity activity where activity.activityUserId = ?1 and activity.activityDate >= ?2 and activity.activityDate <= ?3")
    List<Activity> findByActivityUserIdAndActivityDateBetween(final Long activityUserId, final Date fromDate,
            final Date toDate);
}
