package com.example.activity.utilities;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.activity.enums.ActivityDistanceEnum;

public class DistanceConversionUtilTests {
    @Test
    void checkCoreFeetToMiles() {
        BigDecimal distance = BigDecimal.valueOf(5280);

        Assertions.assertEquals(BigDecimal.valueOf(1), DistanceConversionUtil.convertFeetToMiles(distance));
    }

    @Test
    void checkCoreMilesToFeet() {
        BigDecimal distance = BigDecimal.valueOf(1);

        Assertions.assertEquals(BigDecimal.valueOf(5280), DistanceConversionUtil.convertMilesToFeet(distance));
    }

    @Test
    void checkCoreMetersToKilometers() {
        BigDecimal distance = BigDecimal.valueOf(1000);

        Assertions.assertEquals(BigDecimal.valueOf(1), DistanceConversionUtil.convertMetersToKilometers(distance));
    }

    @Test
    void checkCoreKilometersToMeters() {
        BigDecimal distance = BigDecimal.valueOf(1);

        Assertions.assertEquals(BigDecimal.valueOf(1000), DistanceConversionUtil.convertKilometersToMeters(distance));
    }

    @Test
    void checkCoreKilometersToMiles() {
        BigDecimal distance = BigDecimal.valueOf(4.83);

        //Assertions.assertEquals(BigDecimal.valueOf(3.00), DistanceConversionUtil.convertKilometersToMiles(distance));
        Assertions.assertTrue(BigDecimal.valueOf(3.00).compareTo(DistanceConversionUtil.convertKilometersToMiles(distance)) == 0);
    }

    @Test
    void checkCoreMilesToKilometers() {
        BigDecimal distance = BigDecimal.valueOf(3.00);

        //Assertions.assertEquals(BigDecimal.valueOf(4.83), DistanceConversionUtil.convertMilesToKilometers(distance));
        Assertions.assertTrue(BigDecimal.valueOf(4.83).compareTo(DistanceConversionUtil.convertMilesToKilometers(distance)) == 0);
    }

    @Test 
    void checkFeetToMiles() {
        BigDecimal distance = BigDecimal.valueOf(15840);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.FEET;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.MILES;

        Assertions.assertTrue(BigDecimal.valueOf(3.00).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkFeetToKilometers() {
        BigDecimal distance = BigDecimal.valueOf(15840);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.FEET;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.KILOMETERS;

        Assertions.assertTrue(BigDecimal.valueOf(4.83).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkFeetToMeters() {
        BigDecimal distance = BigDecimal.valueOf(15840);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.FEET;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.METERS;

        Assertions.assertTrue(BigDecimal.valueOf(4830).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkMilesToFeet() {
        BigDecimal distance = BigDecimal.valueOf(3.00);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.MILES;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.FEET;

        Assertions.assertTrue(BigDecimal.valueOf(15840).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkMilesToKilometers() {
        BigDecimal distance = BigDecimal.valueOf(3.00);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.MILES;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.KILOMETERS;

        Assertions.assertTrue(BigDecimal.valueOf(4.83).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkMilesToMeters() {
        BigDecimal distance = BigDecimal.valueOf(3.00);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.MILES;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.METERS;

        Assertions.assertTrue(BigDecimal.valueOf(4830).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkKilometersToFeet() {
        BigDecimal distance = BigDecimal.valueOf(4.83);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.KILOMETERS;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.FEET;

        Assertions.assertTrue(BigDecimal.valueOf(15840).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkKilometersToMiles() {
        BigDecimal distance = BigDecimal.valueOf(4.83);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.KILOMETERS;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.MILES;

        Assertions.assertTrue(BigDecimal.valueOf(3.00).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkKilometersToMeters() {
        BigDecimal distance = BigDecimal.valueOf(4.83);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.KILOMETERS;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.METERS;

        Assertions.assertTrue(BigDecimal.valueOf(4830).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkMetersToFeet() {
        BigDecimal distance = BigDecimal.valueOf(4830);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.METERS;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.FEET;

        Assertions.assertTrue(BigDecimal.valueOf(15840).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkMetersToMiles() {
        BigDecimal distance = BigDecimal.valueOf(4830);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.METERS;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.MILES;

        Assertions.assertTrue(BigDecimal.valueOf(3.00).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }

    @Test 
    void checkMetersToKilometers() {
        BigDecimal distance = BigDecimal.valueOf(4830);
        ActivityDistanceEnum fromDistanceType = ActivityDistanceEnum.METERS;
        ActivityDistanceEnum toDistanceType = ActivityDistanceEnum.KILOMETERS;

        Assertions.assertTrue(BigDecimal.valueOf(4.83).compareTo(DistanceConversionUtil.convertDistance(distance, fromDistanceType, toDistanceType)) == 0);
    }
}
