package com.example.activity.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.activity.usersummary.SummaryTypeEnum;

public class ActivityDateUtilTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityDateUtilTests.class);

    @Test
    void checkThreeDaysIsWeek() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/03/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/3/2024");
        }

        Assertions.assertEquals(true, dateUtil.isDateRangeWeek(fromDate, toDate));
    }

    @Test
    void checkSevenDaysIsWeek() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/07/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/7/2024");
        }

        Assertions.assertEquals(true, dateUtil.isDateRangeWeek(fromDate, toDate));
    }

    @Test
    void checkThirtyDaysIsWeek() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/30/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/30/2024");
        }

        Assertions.assertEquals(false, dateUtil.isDateRangeWeek(fromDate, toDate));
    }

    @Test
    void checkThreeDaysIsMonth() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/03/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/3/2024");
        }

        Assertions.assertEquals(false, dateUtil.isDateRangeMonth(fromDate, toDate));
    }

    @Test
    void checkSevenDaysIsMonth() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/07/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/7/2024");
        }

        Assertions.assertEquals(false, dateUtil.isDateRangeMonth(fromDate, toDate));
    }

    @Test
    void checkThirtyDaysIsMonth() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/30/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/30/2024");
        }

        Assertions.assertEquals(true, dateUtil.isDateRangeMonth(fromDate, toDate));
    }

    @Test
    void check60DaysIsMonth() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("06/10/2024");
            toDate = simpleDateFormat.parse("08/10/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 6/10/2024 to 8/10/2024");
        }

        Assertions.assertEquals(false, dateUtil.isDateRangeMonth(fromDate, toDate));
    }

    @Test
    void check10DaysIsYear() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("06/10/2024");
            toDate = simpleDateFormat.parse("06/20/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 6/10/2024 to 6/20/2024");
        }

        Assertions.assertEquals(false, dateUtil.isDateRangeYear(fromDate, toDate));
    }

    @Test
    void check60DaysIsYear() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("06/10/2024");
            toDate = simpleDateFormat.parse("08/10/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 6/10/2024 to 8/10/2024");
        }

        Assertions.assertEquals(true, dateUtil.isDateRangeYear(fromDate, toDate));
    }

    @Test
    void check367DaysIsYear() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("01/01/2024");
            toDate = simpleDateFormat.parse("01/02/2025");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 01/01/2024 to 01/02/2025");
        }

        Assertions.assertEquals(false, dateUtil.isDateRangeYear(fromDate, toDate));
    }

    @Test
    void checkThreeDaysIsWeekSummary() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/03/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/3/2024");
        }

        Assertions.assertEquals(SummaryTypeEnum.WEEK, dateUtil.getSummaryTypeFromDateRange(fromDate, toDate));
    }

    @Test
    void checkSevenDaysIsWeekSummary() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/07/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/7/2024");
        }

        Assertions.assertEquals(SummaryTypeEnum.WEEK, dateUtil.getSummaryTypeFromDateRange(fromDate, toDate));
    }

    @Test
    void check10DaysIsMonthSummary() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("06/10/2024");
            toDate = simpleDateFormat.parse("06/20/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 6/10/2024 to 6/20/2024");
        }

        Assertions.assertEquals(SummaryTypeEnum.MONTH, dateUtil.getSummaryTypeFromDateRange(fromDate, toDate));
    }

    @Test
    void check31DaysIsMonthSummary() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("07/01/2024");
            toDate = simpleDateFormat.parse("07/31/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 7/1/2024 to 7/31/2024");
        }

        Assertions.assertEquals(SummaryTypeEnum.MONTH, dateUtil.getSummaryTypeFromDateRange(fromDate, toDate));
    }

    @Test
    void check60DaysIsYearSummary() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("06/10/2024");
            toDate = simpleDateFormat.parse("08/10/2024");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 6/10/2024 to 8/10/2024");
        }

        Assertions.assertEquals(SummaryTypeEnum.YEAR, dateUtil.getSummaryTypeFromDateRange(fromDate, toDate));
    }

    @Test
    void check367DaysIsYearSummary() {
        final ActivityDateUtil dateUtil = new ActivityDateUtil();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fromDate = null;
        Date toDate = null;

        try {
            fromDate = simpleDateFormat.parse("01/01/2024");
            toDate = simpleDateFormat.parse("01/02/2025");
        } catch (final Exception exception) {
            LOGGER.error("Unable to parse dates for 01/01/2024 to 01/02/2025");
        }

        Assertions.assertEquals(null, dateUtil.getSummaryTypeFromDateRange(fromDate, toDate));
    }
}
