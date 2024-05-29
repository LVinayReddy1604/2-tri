import java.util.*;

// Employee Management
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

// Sales and Marketing Management
interface Marketing {
    void promoteProduct();
}

class SalesPerson extends Employee implements Marketing {
    public SalesPerson(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public void promoteProduct() {
        System.out.println("Salesperson is promoting a product.");
    }
}

// Stock Management
class Product {
    private int id;
    private String name;
    private int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

// Employee and Stock Management combined
class EmployeeStockManagement {
    private List<Employee> employees;
    private List<Product> products;

    public EmployeeStockManagement() {
        this.employees = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    // Display elements using a lambda expression
    public void displayElements(List<?> elements, DisplayFormatter formatter) {
        System.out.println("Displaying Elements:");
        elements.forEach(element -> System.out.println(formatter.format(element)));
    }

    public void displayEmployees() {
        // Using lambda expression for display
        displayElements(employees, e -> "Employee: " + e.toString());
    }

    public void displayProducts() {
        // Using lambda expression for display
        displayElements(products, p -> "Product: " + p.toString());
    }

    // Functional interface for lambda expression
    @FunctionalInterface
    interface DisplayFormatter {
        String format(Object element);
    }
}

public class BusinessManagementSystem {
    public static void main(String[] args) {
        // Command Line Arguments
        if (args.length > 0) {
            System.out.println("Command Line Arguments:");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No Command Line Arguments");
        }

        // Employee Management
        Employee manager = new Employee(1, "John Manager", 50000.0);
        SalesPerson salesPerson = new SalesPerson(2, "Alice Sales", 40000.0);

        // Stock Management
        Product laptop = new Product(101, "Laptop", 50);
        Product phone = new Product(102, "Phone", 100);

        // Employee and Stock Management combined
        EmployeeStockManagement managementSystem = new EmployeeStockManagement();
        managementSystem.addEmployee(manager);
        managementSystem.addEmployee(salesPerson);
        managementSystem.addProduct(laptop);
        managementSystem.addProduct(phone);

        // Display employees and products
        managementSystem.displayEmployees();
        managementSystem.displayProducts();

        // Sales and Marketing Management
        salesPerson.promoteProduct();

        // Exception Handling
        try {
            // Simulating an exception
            throw new RuntimeException("Simulated Exception");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Lambda Expression
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        names.forEach(name -> System.out.println("Name: " + name));

        // Generics
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Sum of Numbers: " + sum(numbers));

        // Multiple Inheritance (Interface)
        SalesPerson salesManager = new SalesPerson(3, "Bob Sales", 60000.0);
        salesManager.promoteProduct();

        managementSystem.displayEmployees(); // Call it on the managementSystem, not on salesManager
        managementSystem.displayProducts();

        // Packages and Access Modifiers
        // These concepts are already implemented but not explicitly demonstrated here.
        // You can organize your classes into packages and use access modifiers accordingly.
    }

    // Generic method to calculate sum
    private static <T extends Number> double sum(List<T> numbers) {
        double sum = 0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
