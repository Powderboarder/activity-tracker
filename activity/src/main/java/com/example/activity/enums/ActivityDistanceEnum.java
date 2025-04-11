package com.example.activity.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ActivityDistanceEnum
{
    @JsonProperty("FEET")
    FEET
    {
        @Override
        public boolean isImperialMeasurement()
        {
            return true;
        }
    },
    @JsonProperty("MILES")
    MILES
    {
        @Override
        public boolean isImperialMeasurement()
        {
            return true;
        }
    },
    @JsonProperty("METERS")
    METERS
    {
        @Override
        public boolean isMetricMeasurement()
        {
            return true;
        }
    },
    @JsonProperty("KILOMETERS")
    KILOMETERS
    {
        @Override
        public boolean isMetricMeasurement()
        {
            return true;
        }
    };

    public boolean isImperialMeasurement()
    {
        return false;
    }

    public boolean isMetricMeasurement()
    {
        return false;
    }
}
