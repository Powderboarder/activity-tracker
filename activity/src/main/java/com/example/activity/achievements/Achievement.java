package com.example.activity.achievements;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//@Entity
public class Achievement {
    //@Id
    //@GeneratedValue
    //Long achievementId = null;

    @Column(name = "title")
    String title = null;

    @Column(name = "achievementType")
    AchievementTypeEnum achievemetType = null;

    @Column(name = "achievementMetric")
    BigDecimal achievementMetric = null;

    @Column(name = "achievementIcon")
    String achievementIcon = null;

    @Column(name = "complete")
    boolean completed = false;

    @Column(name = "rangeStartDate")
    Date rangeStartDate = null;

    @Column(name = "rangeEndDate")
    Date rangeEndDate = null;

    /*public Long getAchievementId()
    {
        return achievementId;
    }

    public void setAchievementId(final Long achievementId)
    {
        this.achievementId = achievementId;
    }*/

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public AchievementTypeEnum getAchievemetType()
    {
        return achievemetType;
    }

    public void setAchievemetType(final AchievementTypeEnum achievemetType)
    {
        this.achievemetType = achievemetType;
    }

    public BigDecimal getAchievementMetric()
    {
        return achievementMetric;
    }

    public void setAchievementMetric(final BigDecimal achievementMetric)
    {
        this.achievementMetric = achievementMetric;
    }

    public String getAchievementIcon()
    {
        return achievementIcon;
    }

    public void setAchievementIcon(final String achievementIcon)
    {
        this.achievementIcon = achievementIcon;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(final boolean completed)
    {
        this.completed = completed;
    }

    public Date getRangeStartDate()
    {
        return rangeStartDate;
    }

    public void setRangeStartDate(final Date rangeStartDate)
    {
        this.rangeStartDate = rangeStartDate;
    }

    public Date getRangeEndDate()
    {
        return rangeEndDate;
    }

    public void setRangeEndDate(final Date rangeEndDate)
    {
        this.rangeEndDate = rangeEndDate;
    }

}
