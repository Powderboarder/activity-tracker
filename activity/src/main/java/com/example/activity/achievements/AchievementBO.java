package com.example.activity.achievements;

import java.util.ArrayList;
import java.util.List;
import com.example.activity.usersummary.UserActivitySummary;

public class AchievementBO {
    public List<Achievement> getAchievements(List<UserActivitySummary> userActivitySummaryList){
        List<Achievement> achievementList = new ArrayList<Achievement>();

        achievementList.addAll(TimeAchievementUtil.getTotalTimeAchievements(userActivitySummaryList));

        return achievementList;
    }

    public List<Achievement> getAchievements(UserActivitySummary userActivitySummary){
        List<Achievement> achievementList = new ArrayList<Achievement>();

        achievementList.addAll(TimeAchievementUtil.getTotalTimeAchievements(userActivitySummary));

        return achievementList;
    }
}
