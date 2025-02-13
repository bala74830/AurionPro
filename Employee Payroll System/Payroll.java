package PayrollSystem;

public class Payroll {
	private Employee[] employees;
    private int count;

    // Constructor
    public Payroll() {
        employees = new Employee[5]; 
        count = 0;
    }

    // Check if Employee ID is Unique
    public boolean isUniqueId(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                return false;
            }
        }
        return true;
    }

    
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            if (employee.getEmployeeId() < 0) {
                System.out.println("Error: Employee ID cannot be negative.");
                return;
            }
            if (employee.getSalary() < 0) {
                System.out.println("Error: Salary cannot be negative.");
                return;
            }
            if (!isUniqueId(employee.getEmployeeId())) {
                System.out.println("Error: Employee ID must be unique.");
                return;
            }
            employees[count++] = employee;
        } else {
            System.out.println("Payroll is full, cannot add more employees.");
        }
    }

    
    public void displayAllEmployees() {
        System.out.println("\nEmployee Details:");
        for (int i = 0; i < count; i++) {
            employees[i].displayEmployee();
        }
    }

    // Search Employees by Role
    public void searchByRole(jobRole role) {
        System.out.println("\nEmployees with role " + role + ":");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].getRole() == role) {
                employees[i].displayEmployee();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found with role " + role);
        }
    }
}


