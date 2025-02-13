package com.aurionpro.model;

public class DebitCardPayment implements Payment{

	@Override
	public double processPayment(double a) {
		double interest = a *0.03;
		return a+interest;
	}

}
