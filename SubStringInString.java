package com.aurionpro.assignments;

import java.util.Scanner;

public class SubStringInString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Sentence");
		String sentence=scanner.nextLine();
		System.out.println("Enter the substring to find in sentence");
		String substring=scanner.nextLine();
		if(sentence.contains(substring))
		{
			System.out.println("Sentence contains the substring");
			System.out.println("The index at which the substring present is " + sentence.indexOf(substring));
		}
		else
		{
			System.out.println("Substring not found");
		}
	}

}
