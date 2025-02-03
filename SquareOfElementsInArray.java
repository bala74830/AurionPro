package com.aurionpro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class SquareOfElementsInArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array size");
		int size = scanner.nextInt();
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.println("Enter the value for: " + i);
			int val = scanner.nextInt();
			numbers[i] = val;
		}

		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] * numbers[i];
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i] + " ");
		}
	}

}
