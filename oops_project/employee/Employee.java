package employee;

public abstract class Employee {

    private String name;
    private int EmployeeID;
    private String joiningDate;
    public double salary;
    private String Role;
    private int level;
    private int experience;

    Employee() {
        this.level = 0;
        this.experience = 0;
    }

    public Employee(String name, int EmployeeID, String joiningDate) {
        this.name = name;
        this.EmployeeID = EmployeeID;
        this.joiningDate = joiningDate;
        this.level = 0;
        this.experience = 0;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getEmployeeId() {
        return EmployeeID;
    }

    public int getLevel() {
        return level;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getRole() {
        return Role;
    }

    public String setRole(String role) {
        this.Role = role;
        return Role;
    }

    public void setlevel(int level) {
        this.level = level;
    }

    public abstract double setSalary(double newSalary);

    public abstract double setSalary();

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Employee))

            return false;

        Employee employee = (Employee) o;

        return employee.EmployeeID == this.EmployeeID;
    }
}
