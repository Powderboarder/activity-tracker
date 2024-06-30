package com.example.activity.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ActivitySpeedEnum {
    @JsonProperty("FAST")
    FAST("Intense") {
        @Override
        public boolean isActivityFast() {
            return true;
        }
    },
    @JsonProperty("MEDIUM")
    MEDIUM("Moderate") {
        @Override
        public boolean isActivityMedium() {
            return true;
        }
    },
    @JsonProperty("SLOW")
    SLOW("Easy") {
        @Override
        public boolean isActivitySlow() {
            return true;
        }
    },
    @JsonProperty("ANY")
    ANY("Other");

    public String alternativeLabel = null;

    public boolean isActivityFast() {
        return false;
    }

    public boolean isActivityMedium() {
        return false;
    }

    public boolean isActivitySlow() {
        return false;
    }

    ActivitySpeedEnum(final String alternativeLabel) {
        this.alternativeLabel = alternativeLabel;
    }
}
