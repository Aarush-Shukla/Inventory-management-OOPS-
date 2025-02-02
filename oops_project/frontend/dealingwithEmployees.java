package frontend;

import java.util.*;

import employee.Employee;
import inventory.CustomException;
import employee.*;

public class dealingwithEmployees {

    public Employee initialiseEmployee() throws CustomException {

        Scanner sc = new Scanner(System.in);

        String name;
        int employeeId;
        String JoiningDate;
        int experience;
        String role;

        System.out.println("Enter the type of employee: ");
        String type = (sc.nextLine()).toLowerCase();
        System.out.println("Enter the name of the employee: ");
        name = sc.nextLine();
        System.out.println("Enter the employeeId: ");
        employeeId = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Joining Date: ");
        JoiningDate = sc.nextLine();
        System.out.println("Enter the experience: ");
        experience = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the role: ");
        role = sc.nextLine();

        sc.close();
        if (type.equals("manager")) {
            return new manager(name, employeeId, JoiningDate, experience, role);
        } else if (type.equals("salesman")) {
            return new salesman(name, employeeId, JoiningDate, role, experience);
        } else {
            throw new CustomException.NotAType("Employee Type doesn't match", null);
        }

    }

    public List<Employee> initialiseEmployees(int n) throws CustomException {

        List<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < n; i++) {
            employees.add(initialiseEmployee());
        }
        return employees;
    }
}
