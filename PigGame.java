package com.aurionpro.assignments;

import java.util.Random;
import java.util.Scanner;

public class PigGame {

	public static void main(String[] args) {
		String choice;
		int randomnumber = 0, turnsum = 0, totalsum = 0, i = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("The goal is to reach number 20");
		while (i <= 5) {
			if (totalsum <= 20) {
				System.out.println("TURN " + i);
				System.out.println("Roll or Hold?" + " h/r ");
				choice = scanner.nextLine();
				if (choice.equalsIgnoreCase("h")) {
					System.out.println("Score for TURN " + i + " is " + turnsum);
					totalsum += randomnumber;
					i++;
				} else if (choice.equalsIgnoreCase("r")) {
					Random random = new Random();
					randomnumber = random.nextInt(6) + 1;
					System.out.println("Turn Score: " + randomnumber);
					totalsum += randomnumber;
					if (randomnumber == 1) {
						System.out.println("TURN " + i + " Over");
						turnsum = 0;
						i++;
					}
					turnsum += randomnumber;
				}
				if (i == 6 && i < 20) {
					System.out.println("Game Over");
					break;
				}
			} else {
				System.out.println("You won the game the total score is " + totalsum);
				System.out.println("Number of turns u took to win the game " + i);
				break;
			}
		}
	}

}
