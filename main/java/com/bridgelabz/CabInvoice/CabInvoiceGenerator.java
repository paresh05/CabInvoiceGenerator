package com.bridgelabz.CabInvoice;

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

	/**
	 * @param distance is the distance of the journey
	 * @param time is the time of the journey
	 * @return the total fare of the journey
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = (distance * MINIMUM_COST_PER_KILOMETER) + (time * COST_PER_TIME);
		if(totalFare<MINIMUM_FARE) {
			return MINIMUM_FARE;
		}
		else {
			return totalFare;
		}
	}
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return totalFare;
		}
} 