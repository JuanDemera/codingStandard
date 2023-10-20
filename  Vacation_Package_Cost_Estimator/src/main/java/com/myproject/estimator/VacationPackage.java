// Copyright (C) 2023 John

package com.myproject.estimator;


/**
 * Class representing a vacation package.
 *
 * @author John
 */
public class VacationPackage {
    /**
     * The destination location of the vacation.
     */
    private String destination;

    /**
     * The number of travelers in the vacation package.
     */
    private int numberOfTravelers;

    /**
     * The duration in days of the vacation package.
     */
    private int duration;

    /**
     * Constructor to create a new vacation package.
     *
     * @param destination       The destination location of the vacation.
     * @param numberOfTravelers The number of travelers in the vacation package.
     * @param duration          The duration in days of the vacation package.
     */
    public VacationPackage(final String destination, final int numberOfTravelers, final int duration) {
        this.destination = destination;
        this.numberOfTravelers = numberOfTravelers;
        this.duration = duration;
    }

    /**
     * Calculate the total cost of the vacation package.
     *
     * This method calculates the total cost of the vacation
     * such as the destination location, the number of travelers.
     *
     * @return The total cost of the vacation package as an integer value.
     */
    public int calculateCost() {
        double cost = 1000;

        // Extra cost for popular destination
        if (destination.equals("New York City")) {
            cost += 600;
        } else if (destination.equals("Paris")) {
            cost += 500;
        }

        // Group discount
        if (numberOfTravelers > 4 && numberOfTravelers <= 10) {
            cost = cost - (cost * 0.1);
        } else if (numberOfTravelers > 10) {
            cost = cost - (cost * 0.2);
        }

        if (duration < 7) {
            cost += 200;
        } else if (duration > 30 || numberOfTravelers == 2) {
            cost -= 200;
        }

        return (int) cost;
    }
}
