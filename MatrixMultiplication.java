package com.aurionpro;

import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the 1st array size");
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		int[][] numbers = new int[row][column];
		int[][] resultarray;
		System.out.println("Enter the value for array ");
		for (int i = 0; i < row; i++) {
			System.out.println("Enter the values for " + (i + 1) + " row");
			for (int j = 0; j < column; j++) {
				System.out.println("Enter the " + (j + 1) + " column value for " + (i + 1) + " row");
				numbers[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Enter 2nd array size");
		int row2 = scanner.nextInt();
		int column2 = scanner.nextInt();
		int[][] numbers2 = new int[row2][column2];
		System.out.println("Enter the value for array ");
		for (int i = 0; i < row2; i++) {
			System.out.println("Enter the values for " + (i + 1) + " row");
			for (int j = 0; j < column2; j++) {
				numbers2[i][j] = scanner.nextInt();
				System.out.println("Enter the " + (j + 1) + " column value for " + (i + 1) + " row");
			}
		}

		if (column == row2) {
			for (int i = 0; i < numbers.length; i++) {
				System.out.println();
				for (int j = 0; j < numbers.length; j++) {
					System.out.print(numbers[i][j] + " ");
				}
			}
			System.out.println();
			for (int i = 0; i < numbers2.length; i++) {
				System.out.println();
				for (int j = 0; j < numbers2.length; j++) {
					System.out.print(numbers2[i][j] + " ");
				}
			}
			resultarray = new int[row2][column];
			for (int i = 0; i < column; i++) {
				for (int j = 0; j < row2; j++) {
					for (int k = 0; k < column; k++) {
						resultarray[i][j] += numbers[i][k] * numbers2[k][j];
					}
				}
			}
			System.out.println();
			for (int i = 0; i < resultarray.length; i++) {
				System.out.println();
				for (int j = 0; j < resultarray.length; j++) {
					System.out.print(resultarray[i][j] + " ");
				}
			}
		} else {
			System.out.println("Number of columns of 1st array and Number of rows of 2nd array does not match");
		}

	}

}
