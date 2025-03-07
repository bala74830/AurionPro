package com.company.creation.builder.test;

import java.util.Scanner;

import com.company.creation.builder.model.Person;

public class PersonTest {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int numberOfPerson = getnumberOfPerson(sc);
			
			Person[] people = new Person[numberOfPerson];
			
			addPeople(people, sc, numberOfPerson);
			
			display(people);
			
			sc.close();
			
	}
	
	private static Person[] addPeople(Person[] people, Scanner sc, int numberOfPerson )
	{
		for(int i = 0; i < numberOfPerson; i++)
		{
			String name = getName(sc);
			int age = getAge(sc);
			String role = getRole(sc);
			String gender = getGender(sc);
			
			Person.PublicBuilder builder = new Person.PublicBuilder()
					.setName(name).setAge(age).setRole(role).setGender(gender);
			
			if(role.equalsIgnoreCase("student"))
			{
				String grade = getGrade(sc);
				int rollNo = getRollNo(sc,people,i);
				builder.setGrade(grade).setRollNo(rollNo);
			}
			else if(role.equalsIgnoreCase("teacher"))
			{
				String contactNumber = getContactNumber(sc);
				double salary = getSalary(sc);
				String department = getDepartment(sc);
				builder.setContactNumber(contactNumber).setSalary(salary).setDepartment(department);
			}
			else if(role.equalsIgnoreCase("principal"))
			{
				String contactNumber = getContactNumber(sc);
				double salary = getSalary(sc);
				builder.setContactNumber(contactNumber).setSalary(salary);
				
			}
			else if(role.equalsIgnoreCase("peon"))
			{
				double salary = getSalary(sc);
				builder.setSalary(salary);
			}
			else if(role.equalsIgnoreCase("CleaningStaff"))
			{
				double salary = getSalary(sc);
				builder.setSalary(salary);
			}
			
			people[i] = builder.build();
			System.out.println();
		}
		
		return people;
	}
	
	private static void display(Person[] people) {
		System.out.println("All persons entered:");
        for (Person person : people) {
            System.out.println(person);
        }
	}

	private static int getAge(Scanner sc) {
		int age;
		while(true)
		{
			System.out.println("Enter age of the person : ");
			age = sc.nextInt();
			sc.nextLine(); // consume new line
			
			if(age > 0) return age;
			
			System.out.println("Age cannot be negative.....");
		}

	}
	
	private static String getRole(Scanner sc) {
	    while (true) {
	        System.out.print("Enter role (Student/Teacher/Principal/Peon/CleaningStaff): ");
	        String role = sc.nextLine();

	        if (role.matches("student|teacher|principal|peon|cleaningstaff")) {
	            return role;
	        } else {
	            System.out.println("Invalid role. Please enter one of: Student, Teacher, Principal, Peon, CleaningStaff");
	        }
	    }
	}

	private static String getGender(Scanner sc) {
	    while (true) {
	        System.out.print("Enter gender (Male/Female/Other): ");
	        String gender = sc.nextLine();

	        if (gender.matches("male|female|other")) {
	            return gender;
	        } else {
	            System.out.println("Invalid gender. Please enter Male, Female, or Other.");
	        }
	    }
	}

	private static String getContactNumber(Scanner sc) {
	    while (true) {
	        System.out.print("Enter contact number (10 digits): ");
	        String contact = sc.nextLine().trim();

	        if (contact.matches("\\d{10}")) {
	            return contact;
	        } else {
	            System.out.println("Invalid contact number. Please enter exactly 10 digits.");
	        }
	    }
	}

	private static double getSalary(Scanner sc) {
	    while (true) {
	        System.out.print("Enter salary: ");
	        if (sc.hasNextDouble()) {
	            double salary = sc.nextDouble();
	            sc.nextLine(); // consume newline
	            if (salary > 0) {
	                return salary;
	            } else {
	                System.out.println("Salary must be greater than zero.");
	            }
	        } else {
	            System.out.println("Invalid input. Please enter a valid number.");
	            sc.next(); // consume invalid input
	        }
	    }
	}

	private static String getGrade(Scanner sc) {
	    System.out.print("Enter grade: ");
	    return sc.nextLine().trim();
	}

	private static String getDepartment(Scanner sc) {
	    System.out.print("Enter department: ");
	    return sc.nextLine().trim();
	}

	private static int getRollNo(Scanner sc, Person[] people, int i) {
		int number;
	    while (true) {
	        System.out.print("Enter Student Roll Number: ");
	        number = sc.nextInt();
	        sc.nextLine();
	        
	        boolean check = false;
	        
	        for(int j = 0; j < i; j++)
	        {
	        	if(people[j].getRollNo() == number)
	        	{
	        		check = true;
	        		break;
	        	}
	        }
	        
	        if(!check && number > 0)
	        {
	        	return number;
	        }
	        
	        System.out.println("Roll Number must be unique and greater than zero.");
	        
	    }
	}
	
	private static String getName(Scanner sc) {
		while (true)
		{
		    System.out.print("Enter name: ");
		    String name = sc.nextLine().trim();

		    if (name.isEmpty())
		    {
		        System.out.println("Name cannot be empty. Please enter a valid name.");
		    }
		    else if (!name.matches("[a-zA-Z ]+"))
		    {
		        System.out.println("Name should contain only alphabets and spaces. Please try again.");
		    }
		    else
		    {
		        return name;
		    }   
		}
	}

	private static int getnumberOfPerson(Scanner sc) {
		int number;
		while(true)
		{
			System.out.println("Enter number of person you want to add : ");
			number = sc.nextInt();
			sc.nextLine(); // consume new line
			
			if(number > 0) return number;
			
			System.out.println("Enter a positive number .. ");
		}

	}

}