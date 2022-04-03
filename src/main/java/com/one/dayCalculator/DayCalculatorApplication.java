package com.one.dayCalculator;

import com.one.dayCalculator.helpers.DateHelper;

import java.util.Scanner;

import static com.one.dayCalculator.constants.ConsoleColour.*;


public class DayCalculatorApplication {


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(WHITE_BOLD_BRIGHT + "CALCULATE DAYS BETWEEN TWO DATES" + ANSI_RESET);
        System.out.println(WHITE_UNDERLINED + "Enter two dates in the format d/m/yyyy" + ANSI_RESET);
        System.out.println(WHITE_UNDERLINED + "The first date must be before the second." + ANSI_RESET);


        System.out.println("Enter the first date.");
        String firstDate = DateHelper.getDateFromKeyboard(keyboard);

        System.out.println("Enter the second date.");
        String secondDate = DateHelper.getDateFromKeyboard(keyboard);


        try {
            int days = DateHelper.daysBetweenTwoDates(firstDate, secondDate);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("The number of days between " + firstDate + " and " + secondDate + " dates is " + ANSI_GREEN_BOLD + days + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }


    }


}


