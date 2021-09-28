package com.bridgelabz.CabInvoice;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
	
	@Test
	public void givenDistanceAndTimeLessThanMinimumShouldReturnMinimum() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 0.35;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		double distance = 5.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(60, fare, 0.0);
	}
}
