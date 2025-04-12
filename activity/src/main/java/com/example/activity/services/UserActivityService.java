package com.example.activity.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.activity.achievements.AchievementBO;
import com.example.activity.beans.Activity;
import com.example.activity.dto.UserActivityServiceDTO;
import com.example.activity.enums.ActivityTypeEnum;
import com.example.activity.usersummary.SummaryTypeEnum;
import com.example.activity.usersummary.UserActivitySummary;
import com.example.activity.utilities.ActivityDateUtil;
import com.example.activity.utilities.DistanceConversionUtil;

@Service
public class UserActivityService {
    public List<UserActivitySummary> getSummariesFromDateRange(
            final UserActivityServiceDTO userActivityServiceDto)
    {
        //final ActivityDateUtil activityDateUtil = new ActivityDateUtil();
        List<UserActivitySummary> userActivitySummaryList = new ArrayList<UserActivitySummary>();
        //final SummaryTypeEnum summaryType = activityDateUtil.getSummaryTypeFromDateRange(
        //        userActivityServiceDto.getSummaryStartDate(),
        //        userActivityServiceDto.getSummaryEndDate());

        for (ActivityTypeEnum activityType : ActivityTypeEnum.values())
        {
            userActivityServiceDto.setActivityType(activityType);
            userActivitySummaryList.add(getUserActivitySummaryOfType(userActivityServiceDto));
        }

        return userActivitySummaryList;
    }

    private UserActivitySummary getUserActivitySummaryOfType(
            final UserActivityServiceDTO userActivityServiceDto)
    {
        final AchievementBO achievementBO = new AchievementBO();
        final ActivityDateUtil activityDateUtil = new ActivityDateUtil();

        UserActivitySummary userActivitySummary = null;

        Integer totalDuration = Integer.valueOf(0);
        BigDecimal totalDistance = BigDecimal.ZERO;
        BigDecimal activityDistance = BigDecimal.ZERO;
        for (Activity activity : userActivityServiceDto.getActivityList())
        {
            if (activity.getActivityType() == userActivityServiceDto.getActivityType())
            {
                totalDuration = totalDuration + activity.getDurationInMinutes();
                activityDistance = activity.getDistance();
                if (activity.getDistanceMeasurementType() != userActivityServiceDto
                        .getDistanceMeasurementType())
                {
                    activityDistance = DistanceConversionUtil.convertDistance(activityDistance,
                            activity.getDistanceMeasurementType(),
                            userActivityServiceDto.getDistanceMeasurementType());
                }
                totalDistance = totalDistance.add(activityDistance);
            }
        }
        userActivitySummary = new UserActivitySummary();
        userActivitySummary.setActivityUserId(userActivityServiceDto.getActivityUserId());
        userActivitySummary.setActivityType(userActivityServiceDto.getActivityType());
        userActivitySummary.setSummaryStartDate(userActivityServiceDto.getSummaryStartDate());
        userActivitySummary.setSummaryEndDate(userActivityServiceDto.getSummaryEndDate());
        userActivitySummary.setDurationInMinutes(totalDuration);
        userActivitySummary.setDistance(totalDistance);
        userActivitySummary
                .setDistanceMeasurementType(userActivityServiceDto.getDistanceMeasurementType());
        userActivitySummary.setAchievementList(achievementBO.getAchievements(userActivitySummary));

        final SummaryTypeEnum summaryType = activityDateUtil.getSummaryTypeFromDateRange(
                userActivityServiceDto.getSummaryStartDate(),
                userActivityServiceDto.getSummaryEndDate());
        userActivitySummary.setSummaryType(summaryType);

        return userActivitySummary;
    }
}
