package com.one.dayCalculator.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.one.dayCalculator.constants.Messages.INVALID_DATE_MESSAGE;

public class DateHelper {

    public static final String DATE_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)$";

    public DateHelper() {
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int daysInMonth(int month, int year) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonths[1] = 29;
        }
        return daysInMonths[month - 1];
    }


    public static int daysInYear(int year) {
        int days = 0;
        for (int i = 1; i <= 12; i++) {
            days += daysInMonth(i, year);
        }
        return days;
    }

    public static int daysInMonthAndYear(int month1, int year1, int month2, int year2) {

        int days = getYearsBetweenTwoYears(year1, year2).stream().mapToInt(DateHelper::daysInYear).sum();

        for (int i = month1; i <= 12; i++) {
            days += daysInMonth(i, year1);
        }

        for (int i = 1; i < month2; i++) {
            days += daysInMonth(i, year2);

        }

        return days;

    }

    public static List<Integer> getYearsBetweenTwoYears(int year1, int year2) {
        List<Integer> years = new ArrayList<>();
        for (int i = year1 + 1; i < year2; i++) {
            years.add(i);
        }
        return years;
    }

    public static int daysBetweenTwoDates(String firstDate, String secondDate) {
        int day1 = Integer.parseInt(firstDate.split("/")[0]);
        int month1 = Integer.parseInt(firstDate.split("/")[1]);
        int year1 = Integer.parseInt(firstDate.split("/")[2]);
        int day2 = Integer.parseInt(secondDate.split("/")[0]);
        int month2 = Integer.parseInt(secondDate.split("/")[1]);
        int year2 = Integer.parseInt(secondDate.split("/")[2]);

        return daysBetweenTwoDates(day1, month1, year1, day2, month2, year2);
    }

    public static int daysBetweenTwoDates(int day1, int month1, int year1, int day2, int month2, int year2) {

        validateDates(day1, month1, year1, day2, month2, year2);
        int days;

        if (year1 != year2) {
            days = daysInMonthAndYear(month1, year1, month2, year2);
        } else {
            days = getDaysInSameYear(month1, month2, year1);
        }

        if (year2 > year1) {
            if (month2 > month1) {
                if (day2 > day1) {
                    days += day2 - day1;
                } else {
                    days -= day1 - day2;
                }
            } else {
                days -= day1 - day2;
            }
        } else {
            days += day1 - day2;
        }


        return Math.abs(days);
    }

    private static int getDaysInSameYear(int month1, int month2, int year) {
        int days = 0;
        if (month1 <= month2) {
            for (int i = month1; i < month2; i++) {
                days -= daysInMonth(i, year);
            }
        } else {
            for (int i = month2; i < month1; i++) {
                days += daysInMonth(i, year);
            }
        }
        return days;
    }

    private static void validateDates(int day1, int month1, int year1, int day2, int month2, int year2) {
        String firstDate = day1 + "/" + month1 + "/" + year1;
        String secondDate = day2 + "/" + month2 + "/" + year2;

        if (year2 < year1) {
            throw new IllegalArgumentException("Year of first date: " + firstDate + " should be before year second date: " + secondDate);
        } else {
            if (year2 == year1) {
                if (month2 < month1) {
                    throw new IllegalArgumentException("Month of first date: " + firstDate + " should be before month second date: " + secondDate);
                } else {
                    if (month1 == month2 && day2 < day1) {
                        throw new IllegalArgumentException("Day of first date: " + firstDate + " should be before day second date: " + secondDate);
                    }
                }
            }
        }

    }

    public static boolean isValidDate(String date) {
        return date.matches(DATE_PATTERN);
    }

    public static String getDateFromKeyboard(Scanner keyboard) {
        String date = keyboard.nextLine();

        while (!DateHelper.isValidDate(date)) {

            if (!DateHelper.isValidDate(date)) {
                System.out.println(INVALID_DATE_MESSAGE);
            }
            System.out.println("Enter the date in the format d/m/yyyy.");
            date = keyboard.nextLine();
        }
        return date;
    }
}
