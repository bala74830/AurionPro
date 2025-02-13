package PayrollSystem;

public class Employee {
	private int employeeId;
    private String name;
    private double salary;
    private jobRole role;

    // Constructor
    public Employee(int employeeId, String name, double salary, jobRole role) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    // Getters
    public int getEmployeeId() 
    { 
    	return employeeId; 
    }
    public String getName() 
    { 
    	return name; 
    }
    public double getSalary() 
    { 
    	return salary; 
    }
    public jobRole getRole() 
    { 
    	return role; 
    }

    // Setters
    public void setEmployeeId(int employeeId) { 
    	this.employeeId = employeeId; 
    	}
    public void setName(String name) { 
    	this.name = name; 
    	}
    public void setSalary(double salary) {
    	this.salary = salary; 
    	}
    public void setRole(jobRole role) {
    	this.role = role; 
    	}

    // Calculate Bonus Method
    public double calculateBonus() {
        switch (role) {
            case MANAGER: 
            	return salary * 0.20;
            case DEVELOPER:
            case DESIGNER: 
            	return salary * 0.15;
            default: 
            	return salary * 0.10;
        }
    }

    // Display Employee Details
    public void displayEmployee() {
        System.out.printf("ID: %d, Name: %s, Role: %s, Salary: %.2f, Bonus: %.2f\n",
                employeeId, name, role, salary, calculateBonus());
    }
}


