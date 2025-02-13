package com.aurionpro.model;

public class CreditCardPaymnt implements Payment{

	@Override
	public double processPayment(double a) {
		double interest = (a * 0.05);
		return a=interest+a;
	}

}
