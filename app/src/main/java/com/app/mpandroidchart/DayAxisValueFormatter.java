package com.app.mpandroidchart;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by philipp on 02/06/16.
 */
public class DayAxisValueFormatter implements IAxisValueFormatter
{
    public static int day;
    protected String[] mMonths = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private BarLineChartBase<?> chart;

    public DayAxisValueFormatter(BarLineChartBase<?> chart) {
        this.chart = chart;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        if (day==1){
            return getTime(value);
        }else if (day==2){
            return getWeakday((int)value);
        }else{
            return getMonthName((int)value);
        }
//
//        int days = (int) value;
//
//        int year = determineYear(days);
//
//        int month = determineMonth(days);
//        String monthName = mMonths[month % mMonths.length];
//        String yearName = String.valueOf(year);
//
//        if (chart.getVisibleXRange() > 30 * 6) {
//
//            return monthName + " " + yearName;
//        } else {
//
//            int dayOfMonth = determineDayOfMonth(days, month + 12 * (year - 2016));
//
//            String appendix = "th";
//
//            switch (dayOfMonth) {
//                case 1:
//                    appendix = "st";
//                    break;
//                case 2:
//                    appendix = "nd";
//                    break;
//                case 3:
//                    appendix = "rd";
//                    break;
//                case 21:
//                    appendix = "st";
//                    break;
//                case 22:
//                    appendix = "nd";
//                    break;
//                case 23:
//                    appendix = "rd";
//                    break;
//                case 31:
//                    appendix = "st";
//                    break;
//            }
//
////            return dayOfMonth == 0 ? "" : dayOfMonth + appendix + " " + monthName;
////            return dayOfMonth == 0 ? "" : monthName;
//            return dayOfMonth == 0 ? "" : getWeakday(days);
    }

    private String getMonthName(int value) {
        if (value==1)
            return mMonths[0];
        else if (value==2)
            return mMonths[1];
        else if (value==3)
            return mMonths[2];
        else if (value==4)
            return mMonths[3];
        else if (value==5)
            return mMonths[4];
        else if (value==6)
            return mMonths[5];
        else if (value==7)
            return mMonths[6];
        else if (value==8)
            return mMonths[7];
        else if (value==9)
            return mMonths[8];
        else if (value==10)
            return mMonths[9];
        else if (value==11)
            return mMonths[10];
        else if (value==12)
            return mMonths[11];
        else
            return "";
    }


//    private int getDaysForMonth(int month, int year) {
//
//        // month is 0-based
//
//        if (month == 1) {
//            boolean is29Feb = false;
//
//            if (year < 1582)
//                is29Feb = (year < 1 ? year + 1 : year) % 4 == 0;
//            else if (year > 1582)
//                is29Feb = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
//
//            return is29Feb ? 29 : 28;
//        }
//
//        if (month == 3 || month == 5 || month == 8 || month == 10)
//            return 30;
//        else
//            return 31;
//    }
//
//    private int determineMonth(int dayOfYear) {
//
//        int month = -1;
//        int days = 0;
//
//        while (days < dayOfYear) {
//            month = month + 1;
//
//            if (month >= 12)
//                month = 0;
//
//            int year = determineYear(days);
//            days += getDaysForMonth(month, year);
//        }
//
//        return Math.max(month, 0);
//    }
//
//    private int determineDayOfMonth(int days, int month) {
//
//        int count = 0;
//        int daysForMonths = 0;
//
//        while (count < month) {
//
//            int year = determineYear(daysForMonths);
//            daysForMonths += getDaysForMonth(count % 12, year);
//            count++;
//        }
//
//        return days - daysForMonths;
//    }
//
//    private int determineYear(int days) {
//
//        if (days <= 366)
//            return 2016;
//        else if (days <= 730)
//            return 2017;
//        else if (days <= 1094)
//            return 2018;
//        else if (days <= 1458)
//            return 2019;
//        else
//            return 2020;
//    }


    private String getTime(float value) {
        return String.valueOf(value);
    }

    private String getWeakday(int days){
        if (days==0)
            return "Mon";
        else if (days==1)
            return "Tues";
        else if (days==2)
            return "Wed";
        else if (days==3)
            return "Thur";
        else if (days==4)
            return "Fri";
        else if (days==5)
            return "Sat";
        else if (days==6)
            return "Sun";
        else
            return "";
    }
}
