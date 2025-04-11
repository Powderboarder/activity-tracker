package com.example.activity.beans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.example.activity.enums.ActivityDistanceEnum;
import com.example.activity.enums.ActivityTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long activityId = null;

    @Column(name = "activityUserId")
    private Long activityUserId = null;

    @Column(name = "activityDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Detroit")
    private Date activityDate = null;

    @Column(name = "activityType")
    private ActivityTypeEnum activityType = null;

    @Column(name = "durationInMinutes")
    private Integer durationInMinutes = null;

    @Column(name = "distance")
    private BigDecimal distance = null;

    @Column(name = "distanceMeasurementType")
    private ActivityDistanceEnum distanceMeasurementType = null;

    public Activity()
    {}

    public Activity(final Long activityUserId, final Date activityDate,
            final ActivityTypeEnum activityTypeEnum, final Integer durationInMinutes,
            final BigDecimal distance, final ActivityDistanceEnum activityDistanceEnum)
    {
        this.activityUserId = activityUserId;
        this.activityDate = activityDate;
        this.activityType = activityTypeEnum;
        this.durationInMinutes = durationInMinutes;
        this.distance = distance;
        this.distanceMeasurementType = activityDistanceEnum;
    }

    public Activity(final Long activityUserId, final Date activityDate,
            final String activityTypeValue, final Integer durationInMinutes,
            final BigDecimal distance, final String activityDistanceValue)
    {
        this.activityUserId = activityUserId;
        this.activityDate = activityDate;
        this.activityType = ActivityTypeEnum.valueOf(activityTypeValue);
        this.durationInMinutes = durationInMinutes;
        this.distance = distance;
        this.distanceMeasurementType = ActivityDistanceEnum.valueOf(activityDistanceValue);
    }

    public Long getActivityId()
    {
        return activityId;
    }

    public void setActivityId(final Long activityId)
    {
        this.activityId = activityId;
    }

    public Long getActivityUserId()
    {
        return activityUserId;
    }

    public void setActivityUserId(final Long activityUserId)
    {
        this.activityUserId = activityUserId;
    }

    public Date getActivityDate()
    {
        return activityDate;
    }

    public void setActivityDate(final Date activityDate)
    {
        this.activityDate = activityDate;
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

    @Override
    public boolean equals(final Object o)
    {

        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Activity))
        {
            return false;
        }

        Activity activity = (Activity) o;
        return Objects.equals(this.activityId, activity.activityId)
                && Objects.equals(this.activityUserId, activity.activityUserId)
                && Objects.equals(this.activityType, activity.activityType)
                && Objects.equals(this.durationInMinutes, activity.durationInMinutes)
                && Objects.equals(this.distance, activity.distance)
                && Objects.equals(this.distanceMeasurementType, activity.distanceMeasurementType);
    }
}
