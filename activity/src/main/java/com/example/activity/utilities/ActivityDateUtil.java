package com.example.activity.utilities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.example.activity.enums.SummaryTypeEnum;

import io.micrometer.common.util.StringUtils;

public class ActivityDateUtil {
    public boolean isDateRangeWeek(final Date fromDate, final Date toDate)
    {
        boolean isRangeWeek = false;

        long diff = toDate.getTime() - fromDate.getTime();
        long daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if (daysBetween <= 7)
        {
            isRangeWeek = true;
        }
        return isRangeWeek;
    }

    public boolean isDateRangeMonth(final Date fromDate, final Date toDate)
    {
        boolean isRangeMonth = false;

        long diff = toDate.getTime() - fromDate.getTime();
        long daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if (daysBetween > 7 && daysBetween <= 31)
        {
            isRangeMonth = true;
        }
        return isRangeMonth;
    }

    public boolean isDateRangeYear(final Date fromDate, final Date toDate)
    {
        boolean isRangeYear = false;

        long diff = toDate.getTime() - fromDate.getTime();
        long daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if (daysBetween > 31 && daysBetween < 367)
        {
            isRangeYear = true;
        }
        return isRangeYear;
    }

    public SummaryTypeEnum getSummaryTypeFromDateRange(final Date fromDate, final Date toDate)
    {
        SummaryTypeEnum summaryTypeEnum = null;
        String summaryTypeString = null;
        if (isDateRangeWeek(fromDate, toDate))
        {
            summaryTypeString = "WEEK";
        } else if (isDateRangeMonth(fromDate, toDate))
        {
            summaryTypeString = "MONTH";
        } else if (isDateRangeYear(fromDate, toDate))
        {
            summaryTypeString = "YEAR";
        }

        if (StringUtils.isNotBlank(summaryTypeString))
        {
            summaryTypeEnum = SummaryTypeEnum.valueOf(summaryTypeString);
        }
        return summaryTypeEnum;
    }
}
