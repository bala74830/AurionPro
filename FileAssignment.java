package com.aurionpro.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAssignment {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the file name (with extenstion): ");
		String fileName = scanner.nextLine();

		String filePath = "C:\\Users\\bala.konar\\Desktop\\Aurionpro\\";
		String fullFilePath = filePath + fileName;

		File file = new File(fullFilePath);

		try {
			if (file.createNewFile()) {
				System.out.println("File with name : " + fileName + " created succesfully!");
			} else {
				System.out.println("File already exists. We will append the content");
			}

			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);

			System.out.println("Enter the content and type 'Done' on a new line to stop");

			while (true) {
				String line = scanner.nextLine();
				if (line.equalsIgnoreCase("Done")) {
					break;
				}
				writer.write(line);
				writer.newLine();
			}
			writer.close();
			System.out.println("You have finished writing to the file " + fileName);
		} catch (IOException e) {
			System.out.println("Error detected: " + e.getMessage());
		} finally {
			scanner.close();
		}

		System.out.println("Lets display the statistics of the file: ");
		int charCount = 0, lineCount = 0, wordCount = 0;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fullFilePath));

			String currentLine = reader.readLine();
			while (currentLine != null) {
				lineCount++;
				String[] words = currentLine.split("\\s+");
				wordCount += words.length;
				for (String word : words) {
					charCount += word.length();
				}
				currentLine = reader.readLine();
			}
			System.out.println("Number of characters in the file: " + charCount);
			System.out.println("Number of words in the file: " + wordCount);
			System.out.println("Number of lines in the file: " + lineCount);

		} catch (IOException e) {
			System.out.println("Error detected: " + e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Error detected: " + e.getMessage());
			}

		}

	}

}
