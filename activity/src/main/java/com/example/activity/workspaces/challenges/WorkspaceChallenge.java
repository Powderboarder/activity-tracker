package com.example.activity.workspaces.challenges;

import java.time.ZonedDateTime;
import com.example.activity.achievements.AchievementTypeEnum;
import com.example.activity.usersummary.SummaryTypeEnum;

/**
 * Holds challenges for a workspace.
 */
public class WorkspaceChallenge {
    private Integer challengeId = null;
    private Integer workspaceId = null;
    private String name = null;
    private SummaryTypeEnum periodType = null;
    private ZonedDateTime startDate = null;
    private ZonedDateTime endDate = null;
    private AchievementTypeEnum challengeType = null;
}
