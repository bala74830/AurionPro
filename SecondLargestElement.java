package com.aurionpro.array;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestElement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array size");
		int size=scanner.nextInt();
		int[] numbers = new int[size];
		for(int i=0;i<size;i++)
		{
			System.out.println("Enter the value for: "+i);
			int val = scanner.nextInt();
			numbers[i]=val;
		}
		
		int largestnumber=numbers[0];
		int secondlargest=numbers[1];
		for(int i=0;i<numbers.length;i++)
		{
			if(numbers[i]>largestnumber)
			{
				secondlargest=largestnumber;
				largestnumber=numbers[i];
			}
			if(numbers[i]<largestnumber && numbers[i]>secondlargest)
			{
				secondlargest=numbers[i];
			}
		}
		System.out.println("Second Largest element in the array is: "+secondlargest);
	}

}
