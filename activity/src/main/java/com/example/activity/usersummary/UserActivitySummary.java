package com.example.activity.usersummary;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.activity.achievements.Achievement;
import com.example.activity.enums.ActivityDistanceEnum;
import com.example.activity.enums.ActivityTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

public class UserActivitySummary {
    @Column(name = "activityUserId")
    private Long activityUserId = null;

    @Column(name = "summaryStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Detroit")
    private Date summaryStartDate = null;

    @Column(name = "summaryEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Detroit")
    private Date summaryEndDate = null;

    @Column(name = "summaryType")
    private SummaryTypeEnum summaryType = null;

    @Column(name = "activityType")
    private ActivityTypeEnum activityType = null;

    @Column(name = "durationInMinutes")
    private Integer durationInMinutes = null;

    @Column(name = "distance")
    private BigDecimal distance = null;

    @Column(name = "distanceMeasurementType")
    private ActivityDistanceEnum distanceMeasurementType = null;

    @Column(name = "achievementList")
    private List<Achievement> achievementList = new ArrayList<Achievement>();

    public Long getActivityUserId()
    {
        return activityUserId;
    }

    public void setActivityUserId(final Long activityUserId)
    {
        this.activityUserId = activityUserId;
    }

    public Date getSummaryStartDate()
    {
        return summaryStartDate;
    }

    public void setSummaryStartDate(final Date summaryStartDate)
    {
        this.summaryStartDate = summaryStartDate;
    }

    public Date getSummaryEndDate()
    {
        return summaryEndDate;
    }

    public void setSummaryEndDate(final Date summaryEndDate)
    {
        this.summaryEndDate = summaryEndDate;
    }

    public SummaryTypeEnum getSummaryType()
    {
        return summaryType;
    }

    public void setSummaryType(final SummaryTypeEnum summaryType)
    {
        this.summaryType = summaryType;
    }

    public ActivityTypeEnum getActivityType()
    {
        return activityType;
    }

    public void setActivityType(final ActivityTypeEnum activityType)
    {
        this.activityType = activityType;
    }

    public Integer getDurationInMinutes()
    {
        return durationInMinutes;
    }

    public void setDurationInMinutes(final Integer durationInMinutes)
    {
        this.durationInMinutes = durationInMinutes;
    }

    public BigDecimal getDistance()
    {
        return distance;
    }

    public void setDistance(final BigDecimal distance)
    {
        this.distance = distance;
    }

    public ActivityDistanceEnum getDistanceMeasurementType()
    {
        return distanceMeasurementType;
    }

    public void setDistanceMeasurementType(final ActivityDistanceEnum distanceMeasurementType)
    {
        this.distanceMeasurementType = distanceMeasurementType;
    }

    public List<Achievement> getAchievementList()
    {
        return achievementList;
    }

    public void setAchievementList(final List<Achievement> achievementList)
    {
        this.achievementList = achievementList;
    }

}
