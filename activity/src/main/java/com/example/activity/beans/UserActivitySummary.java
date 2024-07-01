package com.example.activity.beans;

import java.math.BigDecimal;
import java.util.Date;

import com.example.activity.enums.ActivityDistanceEnum;
import com.example.activity.enums.ActivityTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class UserActivitySummary {
    @Column(name = "activityUserId")
    private Long activityUserId = null;

    @Column(name = "summaryStartDate")
    @JsonFormat(pattern="yyyy-MM-dd", timezone="America/Detroit")
    private Date summaryStartDate = null;

    @Column(name = "summaryEndDate")
    @JsonFormat(pattern="yyyy-MM-dd", timezone="America/Detroit")
    private Date summaryToDate = null;

    @Column(name = "activityType")
    private ActivityTypeEnum activityType = null;

    @Column(name = "durationInMinutes")
    private Integer durationInMinutes = null;

    @Column(name = "distance")
    private BigDecimal distance = null;

    @Column(name = "distanceMeasurementType")
    private ActivityDistanceEnum distanceMeasurementType = null;
}
