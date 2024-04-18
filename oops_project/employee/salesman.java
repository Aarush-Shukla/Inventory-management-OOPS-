package employee;

public class salesman extends Employee {
    public salesman(String name, int EmployeeID, String joiningDate, String Role, int experience) {
        super(name, EmployeeID, joiningDate);
        this.setExperience(experience);
        this.setRole(Role);
        setSalary();

    }

    public double setSalary() {
        this.salary = 10000 + this.getExperience() * 1000 + 5000 * this.getLevel();
        return this.salary;

    }

    public double setSalary(double salary) {
        this.salary = salary;
        return this.salary;
    }
}