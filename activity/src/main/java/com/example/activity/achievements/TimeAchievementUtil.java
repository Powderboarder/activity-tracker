package com.example.activity.achievements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.activity.usersummary.UserActivitySummary;

public class TimeAchievementUtil {
    private static final String titleSuffix = "Total Minutes";

    public static List<Achievement> getTotalTimeAchievements(final UserActivitySummary userActivitySummary){
        List<UserActivitySummary> userActivitySummaryList = new ArrayList<UserActivitySummary>();
        userActivitySummaryList.add(userActivitySummary);

        return getTotalTimeAchievements(userActivitySummaryList);
    }

    public static List<Achievement> getTotalTimeAchievements(final List<UserActivitySummary> userActivitySummaryList){
        final List<Achievement> achievementList = new ArrayList<Achievement>();
        int totalTime = 0;
        Date startDate = null;
        Date endDate = null;
        if (userActivitySummaryList != null && userActivitySummaryList.size() > 0)
        {
            for (final UserActivitySummary userActivitySummary: userActivitySummaryList){
                totalTime += userActivitySummary.getDurationInMinutes();
            }
            startDate = userActivitySummaryList.get(0).getSummaryStartDate();
            endDate = userActivitySummaryList.get(0).getSummaryEndDate();
        }

        if (totalTime > 0){
            Achievement achievement = null;
            boolean continueCheck = true;
            int retry = 1;
            int checkDuration = 0;
            BigDecimal achievementMetric = null;
            while (continueCheck) {
                continueCheck = checkTimeDuration(retry, totalTime);
                checkDuration = getDurationCheckTime(retry);
                achievement = new Achievement();
                achievement.setTitle(checkDuration + " " + titleSuffix);
                achievement.setAchievemetType(AchievementTypeEnum.TIME);
                achievementMetric = BigDecimal.valueOf(checkDuration);
                achievement.setAchievementMetric(achievementMetric);
                achievement.setRangeStartDate(startDate);
                achievement.setRangeEndDate(endDate);
                achievement.setCompleted(continueCheck);
                achievementList.add(achievement);
                retry++;
            }
        }

        return achievementList;
    }

    private static boolean checkTimeDuration(final int retry, final int duration){
        
        boolean achievementMet = false;
        final int checkDuration = getDurationCheckTime(retry);
        
        if (duration >= checkDuration){
            achievementMet = true;
        }

        return achievementMet;
    }

    private static int getDurationCheckTime(final int retry){
        final int HOUR = 60;
        return HOUR * (retry * 2);
    }
}
