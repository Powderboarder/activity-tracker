package com.example.activity.dto;

import java.util.Date;
import java.util.List;

import com.example.activity.beans.Activity;
import com.example.activity.enums.ActivityDistanceEnum;
import com.example.activity.enums.ActivityTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class UserActivityServiceDTO {
    @Column(name = "activityUserId")
    private Long activityUserId = null;

    @Column(name = "summaryStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Detroit")
    private Date summaryStartDate = null;

    @Column(name = "summaryEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Detroit")
    private Date summaryEndDate = null;

    @Column(name = "activityType")
    private ActivityTypeEnum activityType = null;

    @Column(name = "distanceMeasurementType")
    private ActivityDistanceEnum distanceMeasurementType = null;

    @Column(name = "activityList")
    private List<Activity> activityList = null;

    public Long getActivityUserId()
    {
        return activityUserId;
    }

    public void setActivityUserId(Long activityUserId)
    {
        this.activityUserId = activityUserId;
    }

    public Date getSummaryStartDate()
    {
        return summaryStartDate;
    }

    public void setSummaryStartDate(Date summaryStartDate)
    {
        this.summaryStartDate = summaryStartDate;
    }

    public Date getSummaryEndDate()
    {
        return summaryEndDate;
    }

    public void setSummaryEndDate(Date summaryEndDate)
    {
        this.summaryEndDate = summaryEndDate;
    }

    public ActivityTypeEnum getActivityType()
    {
        return activityType;
    }

    public void setActivityType(ActivityTypeEnum activityType)
    {
        this.activityType = activityType;
    }

    public ActivityDistanceEnum getDistanceMeasurementType()
    {
        return distanceMeasurementType;
    }

    public void setDistanceMeasurementType(ActivityDistanceEnum distanceMeasurementType)
    {
        this.distanceMeasurementType = distanceMeasurementType;
    }

    public List<Activity> getActivityList()
    {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList)
    {
        this.activityList = activityList;
    }

}
