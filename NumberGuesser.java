package com.aurionpro.assignments;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

	public static void main(String[] args) {
		Guess();	}
	public static void Guess() {
		int randomnumber, usernumber;
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		randomnumber = random.nextInt(100) + 1;
		for (int i = 1; i <= 5; i++) {
			System.out.println("Guess the number");
			usernumber = scanner.nextInt();
			if (usernumber > randomnumber) {
				System.out.println("Sorry too high");
			} else if (usernumber < randomnumber) {
				System.out.println("Sorry too low");
			} else if (usernumber == randomnumber) {
				System.out.println("You Won in " + i + " Attempts");
				System.out.println("The Random Number Generated was: " + randomnumber);
				System.out.println("Do u want to continue the game? " + "Yes or No");
				Scanner scanner2 = new Scanner(System.in);
				String continueornot = scanner2.nextLine();
				if (continueornot.equalsIgnoreCase("yes")) {
					Guess();} else {
					System.out.println("Exit the game");
					break;}}
			if (i == 5 && usernumber != randomnumber) {
				System.out.println("Game Over");
				System.out.println("The Random Number Generated was: " + randomnumber);
				System.out.println("Do u want to continue the game? " + "Yes or No");
				Scanner scanner2 = new Scanner(System.in);
				String continueornot = scanner2.nextLine();
				if (continueornot.equalsIgnoreCase("yes")) {
					Guess();
				} else {
					System.out.println("Exit the game");
					break;
				}
			}
		}
	}

}
