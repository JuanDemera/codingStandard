package com.myproject.estimator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VacationPackage {
    private final String destination;
    private final int numberOfTravelers;
    private final int duration;
    private final List<String> selectedAddOns;

    private static final Map<String, Double> ADD_ON_PRICES = Map.of(
        "All-Inclusive Package", 200.0,
        "Adventure Activities Package", 150.0,
        "Spa and Wellness Package", 100.0
    );

    public VacationPackage(final String destination, final int numberOfTravelers, final int duration) {
        this.destination = destination;
        this.numberOfTravelers = numberOfTravelers;
        this.duration = duration;
        this.selectedAddOns = new ArrayList<>();
    }

    public void selectAddOn(String addOn) {
        selectedAddOns.add(addOn);
    }

    public int calculateCost() {
        double cost = 1000;

        for (String addOn : selectedAddOns) {
            Double addOnPrice = ADD_ON_PRICES.get(addOn);
            if (addOnPrice != null) {
                cost += addOnPrice * numberOfTravelers;
            } else {
                System.out.println("Unknown add-on: " + addOn);
            }
        }

        if ("New York City".equals(destination)) {
            cost += 600;
        } else if ("Paris".equals(destination)) {
            cost += 500;
        }

        if (numberOfTravelers > 4 && numberOfTravelers <= 10) {
            cost -= (cost * 0.1);
        } else if (numberOfTravelers > 10) {
            cost -= (cost * 0.2);
        }

        if (duration < 7) {
            cost += 200;
        } else if (duration > 30 || numberOfTravelers == 2) {
            cost -= 200;
        }

        return (int) cost;
    }
}
