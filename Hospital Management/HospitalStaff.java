package HospitalSystem.model;

abstract public class HospitalStaff {
	private int staffId;
    private String name;
    private String department;

    public HospitalStaff(int staffId, String name, String department) {
        this.staffId = staffId;
        this.name = name;
        this.department = department;
    }

    
    public abstract void work();

    // Getters
    public int getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    
    @Override
    public String toString() {
        return "Staff ID: " + staffId + ", Name: " + name + ", Department: " + department;
    }
	

}
