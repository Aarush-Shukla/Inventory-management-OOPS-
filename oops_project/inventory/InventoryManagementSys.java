package inventory;

import java.io.*;
import java.util.*;
import employee.*;

import items.*;

public class InventoryManagementSys implements InventoryManagementInterface {

    public List<Product> products = new ArrayList<Product>();
    public List<Employee> employees = new ArrayList<Employee>();

    public void addProduct(Product product) throws CustomException {

        if (products.contains(product)) {
            throw new CustomException.Duplicate("Product already exists", null);
        }

        products.add(product);
    }

    public void addProduct(Product... products) throws CustomException {
        for (Product p : products) {
            if (this.products.contains(p)) {
                throw new CustomException.Duplicate("Product already exists", null);
            }
            this.products.add(p);
        }
    }

    public void removeProduct(Product product) {

        products.remove(product);

    }

    public void addEmployee(Employee employee) throws CustomException {
        if (!(employees == null) && employees.contains(employee)) {
            throw new CustomException.Duplicate("Employee already exists", null);
        }
        employees.add(employee);
    }

    public void addEmployee(Employee... employees) throws CustomException {
        for (Employee e : employees) {
            if (!(employees == null) && this.employees.contains(e)) {
                throw new CustomException.Duplicate("Employee already exists", null);
            }
            this.employees.add(e);
        }
    }

    public void removeEmployee(Employee employee) {

        employees.remove(employee);
    }

    public void updateProduct(Product product, boolean add) throws CustomException {
        if (add) {
            if (products.contains(product)) {
                for (Product p : products) {
                    if (product.getProductId() == p.getProductId()) {
                        p.setQuantity(product.getQuantity());
                    }
                }

            } else {
                throw new CustomException.NotFound("Product not found", null);
            }
        } else {
            if (products.contains(product)) {
                for (Product p : products) {
                    if (product.getProductId() == p.getProductId()) {
                        if (p.getQuantity() > product.getQuantity()) {
                            p.removeQuantity(product.getQuantity());
                        } else {
                            throw new CustomException.Invalid("Product not enough", null);
                        }
                    }
                }
            } else {
                throw new CustomException.NotFound("Product not found", null);
            }

        }
    }

    public void updateEmployeeDetails(int employeeId, String newRole) {
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                e.setRole(newRole);
            }
        }
    }

    public void updateEmployeeDetails(int employeeId, double newSalary) {
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                e.setSalary(newSalary);
            }
        }
    }

    public void updateEmployeeDetails(int employeeId, String newRole, int level) {
        Employee employee = null;
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                employee = e;
            }
        }
        if (employee.getRole() == newRole) {
            employee.setlevel(level);
            employee.setSalary();
        } else {
            if (newRole.equals("salesman")) {
                salesman e = new salesman(employee.getName(), employee.getEmployeeId(), employee.getJoiningDate(),
                        "salesman", employee.getExperience());
                employees.set(employees.indexOf(employee), e);
            } else if (newRole.equals("manager")) {
                manager e = new manager(employee.getName(), employee.getEmployeeId(), employee.getJoiningDate(),
                        employee.getExperience(), "manager");
                employees.set(employees.indexOf(employee), e);
            } else {
                System.out.println("No such role exists");
            }
        }
    }

    public void displayInventory() throws CustomException.FileIOException {
        File inventoryFile = new File("inventoryFile.txt");

        if (inventoryFile.exists()) {
            inventoryFile.delete();
        }

        if (!inventoryFile.exists()) {
            try {
                if (inventoryFile.createNewFile()) {
                    System.out.println("File created");
                    FileWriter writer = new FileWriter(inventoryFile);

                    for (Product e : products) {
                        writer.write("name: " + (String) e.getName() +
                                " productID: " + Integer.toString(e.getProductId()) +
                                " Price: " + Double.toString(e.getprice()) +
                                " Discount: " + Double.toString(e.getDiscount()) +
                                " DiscountedPrice: " + Double.toString(e.getDiscountedValue()) +
                                "quantity: " + Integer.toString(e.getQuantity()) + "\n");
                    }
                    writer.close();
                    try {
                        FileReader reader = new FileReader(inventoryFile);
                        BufferedReader bufferedReader = new BufferedReader(reader);

                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println(line);
                        }
                        bufferedReader.close();
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {

                throw new CustomException.FileIOException("IO exception in display inventory", e);

            }

        }

    }

    public void displayEmployees() throws CustomException.FileIOException {
        File employeeFile = new File("employeeFile.txt");

        if (employeeFile.exists()) {
            employeeFile.delete();
        }

        if (!employeeFile.exists()) {

            try {
                if (employeeFile.createNewFile()) {
                    System.out.println("File created");
                    FileWriter writer = new FileWriter(employeeFile);

                    for (Employee e : employees) {
                        writer.write("name: " + (String) e.getName() +
                                " EmployeeID: " + Integer.toString(e.getEmployeeId()) +
                                " Salary: " + Double.toString(e.salary) +
                                " Role: " + (String) e.getRole() +
                                " Joining Date: " + (String) e.getJoiningDate() +
                                " level: " + Integer.toString(e.getLevel()) + "\n");
                    }
                    writer.close();
                }
                try {
                    FileReader reader = new FileReader(employeeFile);
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {

                throw new CustomException.FileIOException("IO exception in display employee", e);

            }
        }

    }

}
