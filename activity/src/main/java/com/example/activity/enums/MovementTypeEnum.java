package com.example.activity.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MovementTypeEnum {
    @JsonProperty("FEET")
    FEET {
        @Override
        public boolean isByFoot() {
            return true;
        }
    },
    @JsonProperty("CYCLE")
    CYCLE {
        @Override
        public boolean isByBicycle() {
            return true;
        }
    },
    @JsonProperty("EQUIPMENT")
    EQUIPMENT {
        @Override
        public boolean isByExerciseEquipment() {
            return true;
        }
    },
    @JsonProperty("OTHER")
    OTHER;

    public String alternativeLabel = null;

    public boolean isByFoot() {
        return false;
    }

    public boolean isByBicycle() {
        return false;
    }

    public boolean isByExerciseEquipment() {
        return false;
    }

}
