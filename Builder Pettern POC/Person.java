package com.company.creation.builder.model;

public class Person {

	//Attributes of a person
	private final String name;
	private final int age;
	private final String role;
	private final String gender;
	private final String contactNumber;
	private final double salary;
	private final String grade;
	private final String department;
	private final int rollNo;
	
	private Person(PublicBuilder builder)
	{
		this.name = builder.name;
		this.age = builder.age;
		this.role = builder.role;
		this.gender = builder.gender;
		this.contactNumber = builder.contactNumber;
		this.salary = builder.salary;
		this.grade = builder.grade;
		this.department = builder.department;
		this.rollNo = builder.rollNo;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getRole() {
		return role;
	}
	public String getGender() {
		return gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public double getSalary() {
		return salary;
	}
	public String getGrade() {
		return grade;
	}
	public String getDepartment() {
		return department;
	}
	public int getRollNo() {
		return rollNo;
	}
	
	//inner class to create object
	public static class PublicBuilder{
		private String name;
		private int age;
		private String role;
		private String gender;
		private String contactNumber;
		private double salary;
		private String grade;
		private String department;
		private int rollNo;
		
		//Setters
		public PublicBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public PublicBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		public PublicBuilder setRole(String role) {
			this.role = role;
			return this;
		}
		public PublicBuilder setGender(String gender) {
			this.gender = gender;
			return this;
		}
		public PublicBuilder setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
			return this;
		}
		public PublicBuilder setSalary(double salary) {
			this.salary = salary;
			return this;
		}
		public PublicBuilder setGrade(String grade) {
			this.grade = grade;
			return this;
		}
		public PublicBuilder setDepartment(String department) {
			this.department = department;
			return this;
		}
		public PublicBuilder setRollNo(int rollNo) {
			this.rollNo = rollNo;
			return this;
		}
		
		public Person build()
		{
			Person person = new Person(this);
			return person;
		}
	}
	
	 @Override
	    public String toString() {
	        return "Person{" +
	                "name='" + name + '\'' +
	                ", age=" + age +
	                ", role='" + role + '\'' +
	                ", gender='" + gender + '\'' +
	                ", contactNumber='" + contactNumber + '\'' +
	                ", grade='" + grade + '\'' +
	                ", department='" + department + '\'' +
	                ", salary=" + salary +
	                ", Roll Number ='" + rollNo + '\'' +
	                '}';
	    }
}