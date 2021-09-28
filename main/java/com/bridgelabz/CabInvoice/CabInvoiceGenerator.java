package com.bridgelabz.CabInvoice;

/**
 * @author paresh.praveen_ymedi
 *
 */
public class CabInvoiceGenerator {

	public static final int COST_PER_TIME = 1;
	public final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public final double MINIMUM_FARE = 5;

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

} 