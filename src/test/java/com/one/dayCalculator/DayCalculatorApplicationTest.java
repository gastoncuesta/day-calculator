package com.one.dayCalculator;

import com.one.dayCalculator.helpers.DateHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DayCalculatorApplicationTest {


    @Test
    @DisplayName("Test if the year is a leap year")
    void testLapYear() {
        assertTrue(DateHelper.isLeapYear(2000), "2000 is a leap year");
        assertTrue(DateHelper.isLeapYear(1992), "1992 is a leap year");
        assertFalse(DateHelper.isLeapYear(2022), "2022 is not a leap year");
        assertFalse(DateHelper.isLeapYear(2011), "2011 is not a leap year");
    }

    @Test
    @DisplayName("Number days in the month")
    void testDaysInMonth() {
        assertEquals(31, DateHelper.daysInMonth(1, 2022), "January 2022 has 31 days");
        assertEquals(28, DateHelper.daysInMonth(2, 2022), "February 2022 has 28 days");
        assertEquals(29, DateHelper.daysInMonth(2, 2000), "February 2000 has 29 days");
        assertEquals(30, DateHelper.daysInMonth(4, 1994), "April 2022 has 30 days");
    }

    @Test
    @DisplayName("Number of days in a year")
    void testNumberOfDaysInAYear() {
        assertEquals(365, DateHelper.daysInYear(2022), "2022 has 365 days");
        assertEquals(366, DateHelper.daysInYear(2000), "2000 has 366 days");
    }

    @Test
    @DisplayName("Days Between Two Dates With Same Month Year and Day")
    void testDaysBetweenTwoDatesWithSameMonthAndYear1stDayIsEqualTo2ndDay() {
        assertEquals(0, DateHelper.daysBetweenTwoDates(1, 1, 2022, 1, 1, 2022), "It should be 0 days");
        assertEquals(0, DateHelper.daysBetweenTwoDates(12, 3, 1999, 12, 3, 1999), "It should be 0 days");
    }


    @Test
    @DisplayName("Days Between Two Dates With Same Month And Year 2nd Day Is Greater Than 1st Day")
    void testDaysBetweenTwoDatesWithSameMonthAndYear2ndDayIsGreaterThan1stDay() {
        assertEquals(30, DateHelper.daysBetweenTwoDates(1, 1, 2022, 31, 1, 2022), "It should be 30 days");
        assertEquals(1, DateHelper.daysBetweenTwoDates(12, 3, 1999, 13, 3, 1999), "It should be 1 days");
        assertEquals(16, DateHelper.daysBetweenTwoDates(4, 3, 2022, 20, 3, 2022), "It should be 16 days");
    }

    @Test
    @DisplayName("Days Between Two Dates With Same Month And Year 1st Day Is Greater Than 2nd Day")
    void testDaysBetweenTwoDatesWithSameMonthAndYear1stDayIsGreaterThan2ndDay() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(31, 1, 2022, 1, 1, 2022), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(13, 3, 1999, 12, 3, 1999), "It's not allowed");
    }



    @Test
    @DisplayName("Days between two dates with same days and year and 2nd month is greater than 1st month")
    void testDaysBetweenTwoDatesWithSameDaysAndYearAnd2ndMonthIsGreaterThan1stMonth() {
        assertEquals(90, DateHelper.daysBetweenTwoDates(1, 1, 2022, 1, 4, 2022), "It should be 90 days");
        assertEquals(214, DateHelper.daysBetweenTwoDates(12, 3, 2022, 12, 10, 2022), "It should be 214 days");
    }

    @Test
    @DisplayName("Days between two dates with same days and year and 1st month is greater than 2nd month")
    void testDaysBetweenTwoDatesWithSameDaysAndYearAnd1stMonthIsGreaterThan2ndMonth() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(1, 4, 2022, 1, 1, 2022),  "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(12, 10, 2022, 12, 3, 2022),  "It's not allowed");
    }



    @Test
    @DisplayName("Days between two dates with 1st month is greater than 2nd month and same year and 2nd Day is greater than 1st Day")
    void testDaysBetweenTwoDatesWithDifferentMonthAndSameYearAndDaysAnd2ndDayIsGreaterThan1stDay() {
        assertEquals(32, DateHelper.daysBetweenTwoDates(1, 1, 2022, 2, 2, 2022), "It should be 32 days");
        assertEquals(106, DateHelper.daysBetweenTwoDates(6, 3, 2022, 20, 6, 2022), "It should be 106 days");
        assertEquals(39, DateHelper.daysBetweenTwoDates(7, 1, 2022, 15, 2, 2022), "It should be 39 days");
    }

    @Test
    @DisplayName("Days between two dates with 1st month is greater than 2nd month and same year and 1st Day is greater than 2nd Day")
    void testDaysBetweenTwoDatesWithDifferentMonthAndSameYearAndDaysAnd1stDayIsGreaterThan2ndDay() {
        assertEquals(30, DateHelper.daysBetweenTwoDates(2, 1, 2022, 1, 2, 2022), "It should be 30 days");
        assertEquals(78, DateHelper.daysBetweenTwoDates(20, 3, 2022, 6, 6, 2022), "It should be 78 days");
        assertEquals(23, DateHelper.daysBetweenTwoDates(15, 1, 2022, 7, 2, 2022), "It should be 23 days");
    }

    @Test
    @DisplayName("Days between two dates with 2nd month is greater than 1st month and same year and 1st Day is greater than 2nd Day")
    void testDaysBetweenTwoDates2ndMonthIsGreaterThan1stMonthAndSameYearAnd1stDayIsGreaterThan2ndDay() {
        assertEquals(28, DateHelper.daysBetweenTwoDates(4, 1, 2022, 1, 2, 2022), "It should be 28 days");
        assertEquals(14, DateHelper.daysBetweenTwoDates(20, 1, 2022, 3, 2, 2022), "It should be 14 days");
        assertEquals(23, DateHelper.daysBetweenTwoDates(15, 1, 2022, 7, 2, 2022), "It should be 23 days");
    }

    @Test
    @DisplayName("Days between two dates with 2nd month is greater than 1st month and same year and 1st Day is greater than 2nd Day")
    void testDaysBetweenTwoDates2ndMonthIsGreaterThan1stMonthAndSameYearAnd2ndDayIsGreaterThan1stDay() {
        assertEquals(34, DateHelper.daysBetweenTwoDates(1, 1, 2022, 4, 2, 2022), "It should be 34 days");
        assertEquals(48, DateHelper.daysBetweenTwoDates(3, 1, 2022, 20, 2, 2022), "It should be 48 days");
        assertEquals(39, DateHelper.daysBetweenTwoDates(7, 1, 2022, 15, 2, 2022), "It should be 23 days");
    }



    @Test
    @DisplayName("Days between two dates with same month and days and 2nd year is greater than 1st year")
    void testDaysBetweenTwoDatesWithSameMonthAndDaysAnd2ndYearIsGreaterThan1stYear() {
        assertEquals(365, DateHelper.daysBetweenTwoDates(1, 1, 2022, 1, 1, 2023), "It should be 365 days");
        assertEquals(730, DateHelper.daysBetweenTwoDates(1, 2, 2022, 1, 2, 2024), "It should be 730 days");
        assertEquals(366, DateHelper.daysBetweenTwoDates(1, 3, 2023, 1, 3, 2024), "It should be 366 days");
        assertEquals(731, DateHelper.daysBetweenTwoDates(1, 3, 2022, 1, 3, 2024), "It should be 731 days");
    }

    @Test
    @DisplayName("Days between two dates with same month and days and 1st year is greater than 2nd year")
    void testDaysBetweenTwoDatesWithSameMonthAndDaysAnd1stYearIsGragherThan2ndYear() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(1, 1, 2023, 1, 1, 2021), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(1, 2, 2024, 1, 2, 2020), "It's not allowed");
    }



    @Test
    @DisplayName("Days between two dates with 2nd month is greater than 1st month and 2nd year is greater than 1st year and same days")
    void testDaysBetweenTwoDatesWith2ndMonthIsGreaterThan1stMonthAnd2ndYearIsGreaterThan1stYearAndSameDays() {
        assertEquals(1216, DateHelper.daysBetweenTwoDates(1, 1, 2021, 1, 5, 2024), "It should be 1216 days");
        assertEquals(11048, DateHelper.daysBetweenTwoDates(16, 9, 1992, 16, 12, 2022), "It should be 11048 days");
        assertEquals(486, DateHelper.daysBetweenTwoDates(10, 2, 2023, 10, 6, 2024), "It should be 486 days");
    }

    @Test
    @DisplayName("Days between two dates with 1st month is greater than 2nd month and 2nd year is greater than 1st year and same days")
    void testDaysBetweenTwoDatesWith1stMonthIsGreaterThan2ndMonthAnd2ndYearIsGreaterThan1stYearAndSameDays() {
        assertEquals(975, DateHelper.daysBetweenTwoDates(1, 5, 2021, 1, 1, 2024), "It should be 975 days");
        assertEquals(10866, DateHelper.daysBetweenTwoDates(16, 12, 1992, 16, 9, 2022), "It should be 10866 days");
        assertEquals(5754, DateHelper.daysBetweenTwoDates(28, 5, 2008, 28, 2, 2024), "It should be 5754 days");
    }

    @Test
    @DisplayName("Days between two dates with 2nd month is greater than 1st month and 1st year is greater than 2nd year and same days")
    void testDaysBetweenTwoDatesWith2ndMonthIsGreaterThan1stMonthAnd1stYearIsGreaterThan2ndYearAndSameDays() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(1, 1, 2024, 1, 5, 2021), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(16, 9, 2022, 16, 12, 2000), "It's not allowed");;
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(10, 2, 2024, 10, 6, 1998), "It's not allowed");
    }

    @Test
    @DisplayName("Days between two dates with 1st month is greater than 2nd month and 1st year is greater than 2nd year and same days")
    void testDaysBetweenTwoDatesWith1stMonthIsGreaterThan2ndMonthAnd1stYearIsGreaterThan2ndYearAndSameDays() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(1, 5, 2024, 1, 1, 2021), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(16, 12, 2022, 16, 9, 1992), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(28, 5, 2024, 28, 2, 2008), "It's not allowed");
    }

    @Test
    @DisplayName("Days between two dates with 2nd year is greater than 1st year and 2nd month is greater than 1st month and 2nd day is greater than 1st day")
    void testDaysBetweenTwoDatesWith2ndYearIsGreaterThan1stYearAnd2ndMonthIsGreaterThan1stMonthAnd2ndDayIsGreaterThan1stDay() {
        assertEquals(397, DateHelper.daysBetweenTwoDates(23, 4, 2023, 24, 5, 2024), "It should be 397 days");
        assertEquals(10993, DateHelper.daysBetweenTwoDates(16, 9, 1992, 22, 10, 2022), "It should be 10993 days");
        assertEquals(532, DateHelper.daysBetweenTwoDates(10, 1, 2023, 25, 6, 2024), "It should be 532 days");
    }

    @Test
    @DisplayName("Days between two dates with 2nd year is greater than 1st year and 2nd month is greater than 1st month and 1st day is greater than 2nd day")
    void testDaysBetweenTwoDatesWith2ndYearIsGreaterThan1stYearAnd2ndMonthIsGreaterThan1stMonthAnd1stDayIsGreaterThan2ndDay() {
        assertEquals(372, DateHelper.daysBetweenTwoDates(29, 4, 2023, 5, 5, 2024), "It should be 372 days");
        assertEquals(10974, DateHelper.daysBetweenTwoDates(16, 9, 1992, 3, 10, 2022), "It should be 10974 days");
        assertEquals(502, DateHelper.daysBetweenTwoDates(25, 1, 2023, 10, 6, 2024), "It should be 502 days");
    }

    @Test
    @DisplayName("Days between two dates with 2nd year is greater than 1st year and 1st month is greater than 2nd month and 2nd day is greater than 1st day")
    void testDaysBetweenTwoDatesWith2ndYearIsGreaterThan1stYearAnd1stMonthIsGreaterThan2ndMonthAnd2ndDayIsGreaterThan1stDay() {
        assertEquals(335, DateHelper.daysBetweenTwoDates(24, 5, 2023, 23, 4, 2024), "It should be 335 days");
        assertEquals(10921, DateHelper.daysBetweenTwoDates(22, 10, 1992, 16, 9, 2022), "It should be 10921 days");
        assertEquals(229, DateHelper.daysBetweenTwoDates(10, 6, 2023, 25, 1, 2024), "It should be 229 days");
    }


    @Test
    @DisplayName("Days between two dates with 2nd year is greater than 1st year and 1st month is greater than 2nd month and 1st day is greater 2nd 1st day")
    void testDaysBetweenTwoDatesWith2ndYearIsGreaterThan1stYearAnd1stMonthIsGreaterThan2ndMonthAnd1stDayIsGreaterThan2ndDay() {
        assertEquals(337, DateHelper.daysBetweenTwoDates(23, 5, 2023, 24, 4, 2024), "It should be 337 days");
        assertEquals(10933, DateHelper.daysBetweenTwoDates(16, 10, 1992, 22, 9, 2022), "It should be 10933 days");
        assertEquals(199, DateHelper.daysBetweenTwoDates(25, 6, 2023, 10, 1, 2024), "It should be 199 days");
    }


    @Test
    @DisplayName("Days between two dates with 1st year is greater than 2nd year and 2nd month is greater than 1st month and 2nd day is greater than 1st day")
    void testDaysBetweenTwoDatesWith1stYearIsGreaterThan2ndYearAnd2ndMonthIsGreaterThan1stMonthAnd2ndDayIsGreaterThan1stDay() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(23, 4, 2024, 24, 5, 2023), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(16, 9, 2022, 22, 10, 1999), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(10, 1, 2024, 25, 6, 2022), "It's not allowed");
    }

    @Test
    @DisplayName("Days between two dates with 1st year is greater than 2nd year and 2nd month is greater than 1st month and 1st day is greater than 2nd day")
    void testDaysBetweenTwoDatesWith1stYearIsGreaterThan2ndYearAnd2ndMonthIsGreaterThan1stMonthAnd1stDayIsGreaterThan2ndDay() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(29, 4, 2024, 5, 5, 2023), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(16, 9, 2022, 3, 10, 1992), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(25, 1, 2024, 10, 6, 2023), "It's not allowed");
    }

    @Test
    @DisplayName("Days between two dates with 1st year is greater than 2nd year and 1st month is greater than 2nd month and 2nd day is greater than 1st day")
    void testDaysBetweenTwoDatesWith1stYearIsGreaterThan2ndYearAnd1stMonthIsGreaterThan2ndMonthAnd2ndDayIsGreaterThan1stDay() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(24, 5, 2024, 23, 4, 2023), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(22, 10, 2022, 16, 9, 1992), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(10, 6, 2024, 25, 1, 2023), "It's not allowed");
    }


    @Test
    @DisplayName("Days between two dates with 1st year is greater than 2nd year and 1st month is greater than 2nd month and 1st day is greater 2nd 1st day")
    void testDaysBetweenTwoDatesWith1stYearIsGreaterThan2ndYearAnd1stMonthIsGreaterThan2ndMonthAnd1stDayIsGreaterThan2ndDay() {
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(23, 5, 2024, 24, 4, 2023), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(16, 10, 2022, 22, 9, 1992), "It's not allowed");
        assertThrows(IllegalArgumentException.class, () -> DateHelper.daysBetweenTwoDates(25, 6, 2023, 10, 1, 2023), "It's not allowed");
    }


}
