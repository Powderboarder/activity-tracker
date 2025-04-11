package com.example.activity.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SummaryTypeEnum
{
    @JsonProperty("Weekly")
    WEEK
    {

        @Override
        public boolean isWeeklySummary()
        {
            return true;
        }

    },
    @JsonProperty("Monthly")
    MONTH
    {

        @Override
        public boolean isMonthlySummary()
        {
            return true;
        }

    },
    @JsonProperty("Yearly")
    YEAR
    {

        @Override
        public boolean isYearlySummary()
        {
            return true;
        }

    };

    public boolean isWeeklySummary()
    {
        return false;
    }

    public boolean isMonthlySummary()
    {
        return false;
    }

    public boolean isYearlySummary()
    {
        return false;
    }
}
