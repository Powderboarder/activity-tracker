package com.example.activity.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ActivityTypeEnum
{
    @JsonProperty("JOG")
    JOG("Jogging", MovementTypeEnum.FEET, ActivitySpeedEnum.MEDIUM), @JsonProperty("RUN")
    RUN("Running", MovementTypeEnum.FEET, ActivitySpeedEnum.FAST), @JsonProperty("WALK")
    WALK("Walking", MovementTypeEnum.FEET, ActivitySpeedEnum.SLOW);

    private String activityName = null;

    public String getActivityName()
    {
        return this.activityName;
    }

    ActivityTypeEnum(String string, MovementTypeEnum feet, ActivitySpeedEnum medium)
    {}
}
