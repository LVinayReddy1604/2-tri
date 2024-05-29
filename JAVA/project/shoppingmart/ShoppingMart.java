import java.sql.*;
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

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Method to calculate annual salary
    public double calculateAnnualSalary() {
        return salary * 12; // Assuming salary is monthly
    }

    // Method to insert employee into the database
    public void insertIntoDatabase(Connection connection) throws SQLException {
        String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, getName());
            preparedStatement.setDouble(2, getSalary());
            preparedStatement.executeUpdate();
        }
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
        System.out.println("Salesperson " + getName() + " is promoting a product.");
    }
}

// Stock Management
class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Method to insert product into the database
    public void insertIntoDatabase(Connection connection) throws SQLException {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, getName());
            preparedStatement.setDouble(2, getPrice());
            preparedStatement.setInt(3, getQuantity());
            preparedStatement.executeUpdate();
        }
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
        // Insert into database
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            employee.insertIntoDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        // Insert into database
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            product.insertIntoDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayEmployees() {
        System.out.println("Employees:");
        employees.forEach(employee -> {
            System.out.println(employee);
            System.out.println("Annual Salary: $" + employee.calculateAnnualSalary());
        });
    }

    public void displayProducts() {
        System.out.println("Products:");
        products.forEach(System.out::println);
    }

    // JDBC Connection parameters
    private static final String JDBC_URL = "jdbc:sqlite:shopping_mart.db";


    // JDBC Connection parameters
    private static final String JDBC_URL = "jdbc:sqlite:shopping_mart.db";

    // Create Employee table SQL
    private static final String CREATE_EMPLOYEE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS employees (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "salary DOUBLE NOT NULL)";

    // Create Product table SQL
    private static final String CREATE_PRODUCT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS products (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "price DOUBLE NOT NULL," +
            "quantity INTEGER NOT NULL)";

    // Insert Employee SQL
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (name, salary) VALUES (?, ?)";

    // Insert Product SQL
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

    // Method to initialize the database
    private void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement()) {

            // Create Employee table
            statement.executeUpdate(CREATE_EMPLOYEE_TABLE_SQL);

            // Create Product table
            statement.executeUpdate(CREATE_PRODUCT_TABLE_SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert an employee into the database
    private void insertEmployeeIntoDatabase(Employee employee) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a product into the database
    private void insertProductIntoDatabase(Product product) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Sales Thread
class SalesThread extends Thread {
    private SalesPerson salesPerson;
    private Product product;
    private int quantity;

    public SalesThread(SalesPerson salesPerson, Product product, int quantity) {
        this.salesPerson = salesPerson;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        synchronized (product) {
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                System.out.println(salesPerson.getName() + " sold " + quantity + " " + product.getName() +
                        "(s). Remaining quantity: " + product.getQuantity());
            } else {
                System.out.println("Insufficient stock for " + product.getName() +
                        ". Cannot sell " + quantity + " " + product.getName() + "(s).");
            }
        }
    }
}

public class ShoppingMart {
    public static void main(String[] args) {
        // Initialize the database
        initializeDatabase();

        // Employee Management
        Employee cashier = new Employee(1, "John Cashier", 50000.0);
        SalesPerson salesPerson = new SalesPerson(2, "Alice Sales", 40000.0);

        // Stock Management
        Product laptop = new Product(101, "Laptop", 800.0, 50);
        Product phone = new Product(102, "Phone", 400.0, 100);

        // Employee and Stock Management combined
        EmployeeStockManagement managementSystem = new EmployeeStockManagement();
        managementSystem.addEmployee(cashier);
        managementSystem.addEmployee(salesPerson);
        managementSystem.addProduct(laptop);
        managementSystem.addProduct(phone);

        // Display employees and products
        managementSystem.displayEmployees();
        managementSystem.displayProducts();

        // Sales and Marketing Management
        salesPerson.promoteProduct();

        // Simulate Sales (Multithreading)
        SalesThread salesThread1 = new SalesThread(salesPerson, laptop, 5);
        SalesThread salesThread2 = new SalesThread(salesPerson, phone, 3);

        salesThread1.start();
        salesThread2.start();

        // Display updated stock
        managementSystem.displayProducts();
    }

    // JDBC Connection parameters
    private static final String JDBC_URL = "jdbc:sqlite:shopping_mart.db";

    // Create Employee table SQL
    private static final String CREATE_EMPLOYEE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS employees (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "salary DOUBLE NOT NULL)";

    // Create Product table SQL
    private static final String CREATE_PRODUCT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS products (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "price DOUBLE NOT NULL," +
            "quantity INTEGER NOT NULL)";

    // Method to initialize the database
    private static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement()) {

            // Create Employee table
            statement.executeUpdate(CREATE_EMPLOYEE_TABLE_SQL);

            // Create Product table
            statement.executeUpdate(CREATE_PRODUCT_TABLE_SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
