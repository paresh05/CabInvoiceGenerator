package com.bridgelabz.CabInvoice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paresh.praveen_ymedi
 *
 */
class Ride{

	public double distance;
	public int time;
	public Ride(double distance, int time) {
		this.distance = distance;
		this.time = time;
	}
}
public class CabInvoiceGenerator {

	public static final int COST_PER_TIME = 1;
	public static final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public static final double MINIMUM_FARE = 5;
	
	public static final int PREMIUM_COST_PER_TIME = 2;
	public static final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15.0;
	public static final double PREMIUM_MINIMUM_FARE = 20;
	
	public double totalFare = 0;
	public double numberOfRides;

	/**This Function is used to calculate the total fare
	 * @param distance is the distance of the journey
	 * @param time is the time of the journey
	 * @return the total fare of the journey
	 */
	public double calculateFare(String rideCategory, double distance, int time) {
		if(rideCategory.equalsIgnoreCase("Normal")) {
			double totalFare = (distance * MINIMUM_COST_PER_KILOMETER) + (time * COST_PER_TIME);
			if(totalFare<MINIMUM_FARE) {
				return MINIMUM_FARE;
			}
			else {
				return totalFare;
			}
		}
		else if(rideCategory.equalsIgnoreCase("Premium")) {
			double totalFare = (distance * PREMIUM_MINIMUM_COST_PER_KILOMETER) + (time * PREMIUM_COST_PER_TIME);
			if(totalFare<PREMIUM_MINIMUM_FARE) {
				return PREMIUM_MINIMUM_FARE;
			}
			else {
				return totalFare;
			}
		}
		return 0;
	}

	/**This function is used to calculate the fare of multiple rides
	 * @return the total fare of all the rides
	 */
	public double calculateFare(String rideCategory, Ride[] rides) {
		for(Ride ride : rides) {
			totalFare += calculateFare(rideCategory, ride.distance, ride.time);
			numberOfRides++;
		}
		return totalFare;
	}

	/**This function is used to get the invoice summary
	 * @return the total summary
	 */
	public String invoiceSummary() {
		List<Double> summary = new ArrayList<Double>();
		double avgFare=0.0;
		avgFare = totalFare/numberOfRides;
		summary.add(numberOfRides);
		summary.add(totalFare);
		summary.add(avgFare);
		return summary.toString();
	}
} 