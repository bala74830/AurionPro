package com.aurionpro;

import java.util.Scanner;

public class WaterBillGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of units consumed:");
		int UnitsConsumed = scanner.nextInt();
		int charges = 0, meter_charges = 75;
		if (UnitsConsumed <= 100) {
			charges = UnitsConsumed * 5;
		} else if (UnitsConsumed <= 250) {
			charges = UnitsConsumed * 10;
		} else if (UnitsConsumed > 250) {
			charges = UnitsConsumed * 10;
		}
		int Total_Water_Bill = charges + meter_charges;
		System.out.println("The Total water bill is :" + Total_Water_Bill);
	}

}
