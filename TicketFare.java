package com.aurionpro.assignments;

import java.util.Scanner;

public class TicketFare {

	public static void main(String[] args) {
		int input, amount = 0;
		String option;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your height in cm: ");
		input = scanner.nextInt();
		if (input > 120) {
			System.out.println("Enter your age: ");
			input = scanner.nextInt();
			if (input < 12) {
				amount += 5;
			} else if (input >= 12 && input <= 17) {
				amount += 7;
			} else if (input >= 18 && input <= 44) {
				amount += 12;
			} else if (input >= 45 && input <= 55) {
				amount += 0;
			} else if (input >= 56) {
				System.out.println("Too old to ride");
			}
			if (input < 56) {
				System.out.println("Want Photos? " + "Yes " + "Or " + "No");
				option = scanner.next();
				if (option.equalsIgnoreCase("Yes")) {
					amount += 3;
					System.out.println("The total bill is " + amount);
				} else if (option.equalsIgnoreCase("No")) {
					System.out.println("The total bill is " + amount);
				}
			}
		} else {
			System.out.println("Can't Ride");
		}

	}

}
