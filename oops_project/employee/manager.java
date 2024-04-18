package employee;

public class manager extends Employee {

    public manager(String name, int EmployeeID, String joiningDate, int experience, String Role) {
        super(name, EmployeeID, joiningDate);
        this.setExperience(experience);
        this.setRole(Role);
        setSalary();
    }

    public double setSalary() {
        this.salary = 20000 + this.getExperience() * 2000 + 5000 * this.getLevel();
        return this.salary;

    }

    public double setSalary(double salary) {
        this.salary = salary;
        return this.salary;

    }

}