/**
 * Main class to interact with the user and calculate vacation package costs.
 *
 * This class provides the main method for the vacation package application.
 */
package com.myproject.estimator;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class to interact with the user and calculate vacation package costs.
 */
public class Main {
    /**
     * Main method for the vacation package application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination;
        int numberOfTravelers = 0;
        int duration = 0;

        System.out.print("Please enter your holiday destination: ");
        destination = scanner.nextLine();

        Pattern pattern = Pattern.compile("^[A-Z][a-z]+");
        Matcher matcher = pattern.matcher(destination);
        if (!matcher.matches()) {
            System.out.println("Please enter a string that begins with a capital letter.");
        }

        System.out.print("Please enter the number of travelers:");
        try {
            numberOfTravelers = scanner.nextInt();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.print("Please enter the duration of the vacation in days: ");
        try {
            duration = scanner.nextInt();
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

        VacationPackage vp = new VacationPackage(destination, numberOfTravelers, duration);
        int cost = vp.calculateCost();

        if (cost == -1) {
            System.out.println("The input data is not valid.");
        } else {
            System.out.println("The total cost of the vacation package is: $" + cost);
        }
        scanner.close();
    }
}
