package com.example.activity.utilities;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceConversionUtilTests {
    @Test
    void checkFeetToMiles() {
        BigDecimal distance = BigDecimal.valueOf(5280);

        Assertions.assertEquals(BigDecimal.valueOf(1), DistanceConversionUtil.convertFeetToMiles(distance));
    }

    @Test
    void checkMilesToFeet() {
        BigDecimal distance = BigDecimal.valueOf(1);

        Assertions.assertEquals(BigDecimal.valueOf(5280), DistanceConversionUtil.convertMilesToFeet(distance));
    }

    @Test
    void checkMetersToKilometers() {
        BigDecimal distance = BigDecimal.valueOf(1000);

        Assertions.assertEquals(BigDecimal.valueOf(1), DistanceConversionUtil.convertMetersToKilometers(distance));
    }

    @Test
    void checkKilometersToMeters() {
        BigDecimal distance = BigDecimal.valueOf(1);

        Assertions.assertEquals(BigDecimal.valueOf(1000), DistanceConversionUtil.convertKilometersToMeters(distance));
    }

    @Test
    void checkKilometersToMiles() {
        BigDecimal distance = BigDecimal.valueOf(4.83);

        //Assertions.assertEquals(BigDecimal.valueOf(3.00), DistanceConversionUtil.convertKilometersToMiles(distance));
        Assertions.assertTrue(BigDecimal.valueOf(3.00).compareTo(DistanceConversionUtil.convertKilometersToMiles(distance)) == 0);
    }

    @Test
    void checkMilesToKilometers() {
        BigDecimal distance = BigDecimal.valueOf(3.00);

        //Assertions.assertEquals(BigDecimal.valueOf(4.83), DistanceConversionUtil.convertMilesToKilometers(distance));
        Assertions.assertTrue(BigDecimal.valueOf(4.83).compareTo(DistanceConversionUtil.convertMilesToKilometers(distance)) == 0);
    }
}
