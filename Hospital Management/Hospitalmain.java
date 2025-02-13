package HospitalSystem.test;

import java.util.ArrayList;
import java.util.Scanner;

import HospitalSystem.model.*;

public class Hospitalmain {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<HospitalStaff> staffMembers = new ArrayList<>();

        // Input Validation for Number of Staff Members
        int numStaff = getPositiveIntegerInput(scanner, "Enter number of staff members: ");

        for (int i = 0; i < numStaff; i++) {
            try {
                System.out.println("\nEnter details for Staff #" + (i + 1));

                int staffId;
                while (true) {
                    staffId = getPositiveIntegerInput(scanner, "Enter Staff ID (Positive Unique Integer): ");

                    // Ensure ID is unique
                    boolean isUnique = true;
                    for (HospitalStaff staff : staffMembers) {
                        if (staff.getStaffId() == staffId) {
                            isUnique = false;
                            break;
                        }
                    }

                    if (isUnique) {
                        break;
                    } else {
                        System.out.println("Error: Staff ID must be unique. Try again.");
                    }
                }

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Department: ");
                String department = scanner.nextLine();

                System.out.print("Is this staff a Doctor or Nurse? (D/N): ");
                char type = scanner.next().charAt(0);
                scanner.nextLine(); 

                if (Character.toLowerCase(type) == 'd') {
                    System.out.print("Enter Specialization: ");
                    String specialization = scanner.nextLine();

                    // Input Validation for Number of Patients
                    int numPatients = getPositiveIntegerInput(scanner, "Enter number of patients: ");

                    String[] patients = new String[numPatients];
                    for (int j = 0; j < numPatients; j++) {
                        System.out.print("Enter Patient Name #" + (j + 1) + ": ");
                        patients[j] = scanner.nextLine();
                    }

                    staffMembers.add(new Doctor(staffId, name, department, specialization, patients));
                } else if (Character.toLowerCase(type) == 'n') {
                    System.out.print("Enter Shift Timings (Morning/Evening/Night): ");
                    String shiftTimings = scanner.nextLine();

                    staffMembers.add(new Nurse(staffId, name, department, shiftTimings));
                } else {
                    System.out.println("Invalid input. Skipping this staff member.");
                    i--; // Adjust index to allow re-input
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
                scanner.nextLine(); // Consume any invalid input
                i--; // Adjust index to allow re-input
            }
        }

        scanner.close();

        // Display details of all staff members
        System.out.println("\nHospital Staff Details:");
        for (HospitalStaff staff : staffMembers) {
            System.out.println(staff);
            staff.work();
            System.out.println();
        }
    }

    // Method to get a positive integer input with validation
    public static int getPositiveIntegerInput(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); 
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Error: Please enter a positive integer.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a positive integer.");
                scanner.next(); // Consume invalid input
            }
        }
    }
	
}

            
        
