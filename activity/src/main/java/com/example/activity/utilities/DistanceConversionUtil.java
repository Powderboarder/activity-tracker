package com.example.activity.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.activity.enums.ActivityDistanceEnum;

public class DistanceConversionUtil {
    final static BigDecimal FEET_IN_MILES = BigDecimal.valueOf(5280);
    final static BigDecimal MILES_IN_KILOMETER = BigDecimal.valueOf(0.621371);

    public static BigDecimal convertDistance(final BigDecimal distance, final ActivityDistanceEnum fromDistanceType,
            final ActivityDistanceEnum toDistanceType) {
        BigDecimal convertedDistance = distance;
        if (toDistanceType == ActivityDistanceEnum.FEET) {
            convertedDistance = convertToFeet(convertedDistance, fromDistanceType);
        } else if (toDistanceType == ActivityDistanceEnum.MILES) {
            convertedDistance = convertToMiles(convertedDistance, fromDistanceType);
        } else if (toDistanceType == ActivityDistanceEnum.METERS) {
            convertedDistance = convertToMeters(convertedDistance, fromDistanceType);
        } else if (toDistanceType == ActivityDistanceEnum.KILOMETERS) {
            convertedDistance = convertToKilometers(convertedDistance, fromDistanceType);
        }
        return convertedDistance;
    }

    public static BigDecimal convertToFeet(final BigDecimal distance, final ActivityDistanceEnum fromDistanceType) {
        BigDecimal convertedDistance = distance;
        if (fromDistanceType == ActivityDistanceEnum.MILES) {
            convertedDistance = convertMilesToFeet(convertedDistance);
        } else if (fromDistanceType == ActivityDistanceEnum.METERS) {
            convertedDistance = convertMetersToKilometers(convertedDistance);
            convertedDistance = convertKilometersToMiles(convertedDistance);
            convertedDistance = convertMilesToFeet(convertedDistance);
        } else if (fromDistanceType == ActivityDistanceEnum.KILOMETERS) {
            convertedDistance = convertKilometersToMiles(convertedDistance);
            convertedDistance = convertMilesToFeet(convertedDistance);
        }
        return convertedDistance;
    }

    public static BigDecimal convertToMiles(final BigDecimal distance, final ActivityDistanceEnum fromDistanceType) {
        BigDecimal convertedDistance = distance;
        if (fromDistanceType == ActivityDistanceEnum.FEET) {
            convertedDistance = convertFeetToMiles(convertedDistance);
        } else if (fromDistanceType == ActivityDistanceEnum.METERS) {
            convertedDistance = convertMetersToKilometers(convertedDistance);
            convertedDistance = convertKilometersToMiles(convertedDistance);
        } else if (fromDistanceType == ActivityDistanceEnum.KILOMETERS) {
            convertedDistance = convertKilometersToMiles(convertedDistance);
        }
        return convertedDistance;
    }

    public static BigDecimal convertToMeters(final BigDecimal distance, final ActivityDistanceEnum fromDistanceType) {
        BigDecimal convertedDistance = distance;
        if (fromDistanceType == ActivityDistanceEnum.FEET) {
            convertedDistance = convertFeetToMiles(convertedDistance);
            convertedDistance = convertMilesToKilometers(convertedDistance);
            convertedDistance = convertKilometersToMeters(convertedDistance);
        } else if (fromDistanceType == ActivityDistanceEnum.MILES) {
            convertedDistance = convertMilesToKilometers(convertedDistance);
            convertedDistance = convertKilometersToMeters(convertedDistance);
        } else if (fromDistanceType == ActivityDistanceEnum.KILOMETERS) {
            convertedDistance = convertKilometersToMeters(convertedDistance);
        }
        return convertedDistance;
    }

    public static BigDecimal convertToKilometers(final BigDecimal distance,
            final ActivityDistanceEnum fromDistanceType) {
        BigDecimal convertedDistance = distance;
        if (fromDistanceType == ActivityDistanceEnum.FEET) {
            convertedDistance = convertFeetToMiles(convertedDistance);
            convertedDistance = convertMilesToKilometers(convertedDistance);
        } else if (fromDistanceType == ActivityDistanceEnum.MILES) {
            convertedDistance = convertMilesToKilometers(convertedDistance);
        } else if (fromDistanceType == ActivityDistanceEnum.METERS) {
            convertedDistance = convertMetersToKilometers(convertedDistance);
        }
        return convertedDistance;
    }

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

    public static BigDecimal convertMilesToKilometers(final BigDecimal distance) {
        BigDecimal convertedDistance = null;
        if (distance != null) {
            convertedDistance = distance.divide(MILES_IN_KILOMETER, 2, RoundingMode.HALF_UP);
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

    public static BigDecimal convertKilometersToMiles(final BigDecimal distance) {
        BigDecimal convertedDistance = null;
        if (distance != null) {
            convertedDistance = distance.multiply(MILES_IN_KILOMETER).setScale(2, RoundingMode.HALF_UP);
        }
        return convertedDistance;
    }
}
