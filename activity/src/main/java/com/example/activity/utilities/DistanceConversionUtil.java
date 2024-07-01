package com.example.activity.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DistanceConversionUtil {
    final static BigDecimal FEET_IN_MILES = BigDecimal.valueOf(5280);
    final static BigDecimal MILES_IN_KILOMETER = BigDecimal.valueOf(0.621371);

    public static BigDecimal convertFeetToMiles(final BigDecimal distance) {
        BigDecimal convertedDistance = null;
        if (distance != null) {
            convertedDistance = distance.divide(FEET_IN_MILES);
        }
        return convertedDistance;
    }

    public static BigDecimal convertMilesToFeet(final BigDecimal distance) {
        BigDecimal convertedDistance = null;
        if (distance != null) {
            convertedDistance = distance.multiply(FEET_IN_MILES);
        }
        return convertedDistance;
    }

    public static BigDecimal convertMetersToKilometers(final BigDecimal distance) {
        BigDecimal convertedDistance = null;
        if (distance != null) {
            convertedDistance = distance.divide(BigDecimal.valueOf(1000));
        }
        return convertedDistance;
    }

    public static BigDecimal convertKilometersToMeters(final BigDecimal distance) {
        BigDecimal convertedDistance = null;
        if (distance != null) {
            convertedDistance = distance.multiply(BigDecimal.valueOf(1000));
        }
        return convertedDistance;
    }

    public static BigDecimal convertMilesToKilometers(final BigDecimal distance) {
        BigDecimal convertedDistance = null;
        if (distance != null) {
            convertedDistance = distance.divide(MILES_IN_KILOMETER, 2, RoundingMode.HALF_UP);
        }
        return convertedDistance;
    }

    public static BigDecimal convertKilometersToMiles(final BigDecimal distance) {
        BigDecimal convertedDistance = null;
        if (distance != null) {
            convertedDistance = distance.multiply(MILES_IN_KILOMETER).setScale(2, RoundingMode.HALF_UP);
        }
        return convertedDistance;
    }
}
