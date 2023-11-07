package com.myproject.estimator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = getInput("Please enter your holiday destination: ");
        if (!isCapitalized(destination)) {
            System.out.println("Please enter a string that begins with a capital letter.");
            return; // Exit the program due to invalid input
        }

        int numberOfTravelers = getInputAsInt("Please enter the number of travelers: ");
        int duration = getInputAsInt("Please enter the duration of the vacation in days: ");

        VacationPackage vp = new VacationPackage(destination, numberOfTravelers, duration);

        // Allow the user to select add-ons
        System.out.println("Available add-ons: ");
        displayAddOns();
        int addonChoice = getInputAsInt("Enter the number of the add-ons you want to select (0 for none): ");
        for (int i = 0; i < addonChoice; i++) {
            String addon = getInput("Enter the name of add-on " + (i + 1) + ": ");
            vp.selectAddOn(addon);
        }

        int cost = vp.calculateCost();

        if (cost == -1) {
            System.out.println("The input data is not valid.");
        } else {
            System.out.println("The total cost of the vacation package is: $" + cost);
        }

        scanner.close();
    }

    private static String getInput(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int getInputAsInt(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Invalid input for the number of travelers.");
            System.exit(1); // Exit the program due to invalid input
        }
        return input;
    }

    private static boolean isCapitalized(String input) {
        return input.matches("^[A-Z][a-z]*");
    }

    private static void displayAddOns() {
        System.out.println("1. All-Inclusive Package - $200 per traveler");
        System.out.println("2. Adventure Activities Package - $150 per traveler");
        System.out.println("3. Spa and Wellness Package - $100 per traveler");
    }
}
