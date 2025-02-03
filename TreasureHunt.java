package com.aurionpro;

import java.util.Scanner;

public class TreasureHunt {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String path;
		System.out.println("Welcome to the Treasure island. Your mission is to find the treasure");
		System.out.println("Left? or Right?");
		path = scanner.nextLine();
		if (path.equalsIgnoreCase("Right")) {
			System.out.println("Fall into a hole.");
			System.out.println("Game over");
		} else if (path.equalsIgnoreCase("Left")) {
			System.out.println("swim? or wait?");
			path = scanner.nextLine();
			if (path.equalsIgnoreCase("swim")) {
				System.out.println("Attacked by trout.");
				System.out.println("Game over");
			} else if (path.equalsIgnoreCase("wait")) {
				System.out.println("Which door : Red? or Blue? or Yellow?");
				path = scanner.nextLine();
				if (path.equalsIgnoreCase("Red")) {
					System.out.println("Burned by fire.");
					System.out.println("Game over");
				} else if (path.equalsIgnoreCase("Blue")) {
					System.out.println("Eaten by beasts.");
					System.out.println("Game over");
				} else if (path.equalsIgnoreCase("Yellow")) {
					System.out.println("You Win");
				} else {
					System.out.println("Game over");
				}
			} else {
				System.out.println("Game over");
			}
		} else {
			System.out.println("Game over");
		}
	}
}
