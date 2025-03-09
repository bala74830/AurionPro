package structural.adapter.example.test;

import java.util.HashSet;
import java.util.Scanner;

import structural.adapter.example.model.Adapter;
import structural.adapter.example.model.GoogleDriveAPI;

public class AdapterMainTest {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> uploadedFiles = new HashSet<>();
        
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Upload");
            System.out.println("2. Delete");
            System.out.println("3. Download");
            System.out.println("4. Exit");
            
            System.out.println("Enter the option number or name:");
            String input = scanner.nextLine().trim().toLowerCase();
            
            String function;
            switch (input) {
                case "1":
                case "upload":
                    function = "upload";
                    break;
                case "2":
                case "delete":
                    function = "delete";
                    break;
                case "3":
                case "download":
                    function = "download";
                    break;
                case "4":
                case "exit":
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Error: Invalid choice. Please select a valid option.");
                    continue;
            }
            
            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine().trim();
            
            // Validate file name
            if (fileName.isEmpty()) {
                System.out.println("Error: File name cannot be empty.");
                continue;
            }
            
            // Check file existence for delete and download operations
            if ((function.equals("delete") || function.equals("download")) && !uploadedFiles.contains(fileName)) {
                System.out.println("Error: File name doesn't exist.");
                continue;
            }
            
            // Track uploaded files
            if (function.equals("upload")) {
                uploadedFiles.add(fileName);
            } else if (function.equals("delete")) {
                uploadedFiles.remove(fileName);
            }
            
            // Create Adapter instance and execute operation
            GoogleDriveAPI fileOperation = new Adapter(function);
            fileOperation.newfunction(fileName, function);
            
            System.out.println("Do you want to continue? (yes/no):");
            String continueChoice = scanner.nextLine().trim().toLowerCase();
            
            if (!continueChoice.equals("yes")) {
                System.out.println("Exiting program...");
                break;
            }
        }
        
        scanner.close();
    }
}
