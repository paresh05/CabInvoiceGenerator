package com.bridgelabz.CabInvoice;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
	
	@Test
	public void givenDistanceAndTimeLessThanMinimumShouldReturnMinimum() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 0.35;
		int time = 1;
		double fare = invoiceGenerator.calculateFare("Normal",distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 5.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare("Normal",distance, time);
		Assert.assertEquals(60, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRidesShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(0.35, 1), new Ride(5.0, 10) };
		double fare = invoiceGenerator.calculateFare("Normal",rides);
		Assert.assertEquals(65, fare, 0.0);
		Assert.assertEquals("[2.0, 65.0, 32.5]", invoiceGenerator.invoiceSummary());
	}
	
	@Test
	public void givenDistanceAndTimeOfPremiumRideShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 5.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare("Premium",distance, time);
		Assert.assertEquals(95, fare, 0.0);
	}
	
}
