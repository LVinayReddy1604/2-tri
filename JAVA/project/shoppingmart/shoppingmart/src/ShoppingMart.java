import java.sql.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public int getId(){
        return id;
    }

    public static boolean isValidEmployeeData(String name, String salary) {
        return name != null && !name.isEmpty() && salary != null && salary.matches("\\d+(\\.\\d+)?");
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

    public int getId(){
        return id;
    }

    // Validate product data
    public static boolean isValidProductData(String name, String price, String quantity) {
        return name != null && !name.isEmpty() && price != null && price.matches("\\d+(\\.\\d+)?") &&
                quantity != null && quantity.matches("\\d+");
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
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD)) {
            employee.insertIntoDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        // Insert into database
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD)) {
            product.insertIntoDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidDatabaseParameters(String dbUrl, String user, String password) {
        return dbUrl != null && !dbUrl.isEmpty() && user != null && !user.isEmpty() && password != null;
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

    public void updateEmployeeInDatabase(Employee employee) {
        String sql = "UPDATE employees SET name=?, salary=? WHERE id=?";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setInt(3, employee.getId());  // Assuming id is the primary key

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update a product in the database
    public void updateProductInDatabase(Product product) {
        String sql = "UPDATE products SET name=?, price=?, quantity=? WHERE id=?";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setInt(4, product.getId());  // Assuming id is the primary key

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // JDBC Connection parameters
    static final String DB_URL = "jdbc:mysql://localhost/MartDB";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static final String DATABASE_NAME = "MartDB";

    // Create Employee table SQL
    private static final String CREATE_EMPLOYEE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS employees (" +
            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
            "name TEXT NOT NULL," +
            "salary DOUBLE NOT NULL)";

    // Create Product table SQL
    private static final String CREATE_PRODUCT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS products (" +
            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
            "name TEXT NOT NULL," +
            "price DOUBLE NOT NULL," +
            "quantity INTEGER NOT NULL)";

    // Insert Employee SQL
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (name, salary) VALUES (?, ?)";

    // Insert Product SQL
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

    // Method to initialize the database
    private void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
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
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
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
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //function to display all elements in the database
    public List<Employee> getAllEmployeesFromDatabase() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                employees.add(new Employee(id, name, salary));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Method to fetch all products from the database
    public List<Product> getAllProductsFromDatabase() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM products")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                products.add(new Product(id, name, price, quantity));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
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

class EmployeeStockManagementGUI extends JFrame {
    private EmployeeStockManagement managementSystem;

    // Swing components
    private JTextArea outputTextArea;
    private JButton displayEmployeesButton;
    private JButton displayProductsButton;
    private JButton addEmployeeButton;
    private JButton addProductButton;
    private JButton updateEmployeeButton;
    private JButton updateProductButton;
    private JButton refreshButton;

    public EmployeeStockManagementGUI() {
        // Initialize the database
        initializeDatabase();

        // Initialize the management system
        managementSystem = new EmployeeStockManagement();

        // Set up the GUI
        setupUI();

        // Set up event listeners
        setupListeners();
    }

    private void setupUI() {
        setTitle("Employee and Stock Management System");
    setSize(1000, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create components
    outputTextArea = new JTextArea();
    displayEmployeesButton = new JButton("Display Employees");
    displayProductsButton = new JButton("Display Products");
    addEmployeeButton = new JButton("Add Employee");
    addProductButton = new JButton("Add Product");
    updateEmployeeButton = new JButton("Update Employee");
    updateProductButton = new JButton("Update Product");
    refreshButton = new JButton("Clear");

    // Set layout manager
    setLayout(new BorderLayout());

    // Add components to the frame
    add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(displayEmployeesButton);
    buttonPanel.add(displayProductsButton);
    buttonPanel.add(addEmployeeButton);
    buttonPanel.add(addProductButton);
    buttonPanel.add(updateEmployeeButton);
    buttonPanel.add(updateProductButton);
    buttonPanel.add(refreshButton);

    // Add the buttonPanel to the South
    add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupListeners() {
        displayEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayEmployees();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTextArea();
            }
        });

        displayProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayProducts();
            }
        });

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        updateEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });

        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProduct();
            }
        });
    }

    private void refreshTextArea() {
        outputTextArea.setText("");  // Clear the text area
        
    }

    

    static final String DB_URL = "jdbc:mysql://localhost/MartDB";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static final String DATABASE_NAME = "MartDB";

    // Create Employee table SQL
    private static final String CREATE_EMPLOYEE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS employees (" +
            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
            "name TEXT NOT NULL," +
            "salary DOUBLE NOT NULL)";

    // Create Product table SQL
    private static final String CREATE_PRODUCT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS products (" +
            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
            "name TEXT NOT NULL," +
            "price DOUBLE NOT NULL," +
            "quantity INTEGER NOT NULL)";

    private void displayEmployees() {
        outputTextArea.append("Employees:\n");
        managementSystem.getAllEmployeesFromDatabase().forEach(employee -> {
            outputTextArea.append(employee.toString() + "\n");
            outputTextArea.append("Annual Salary: $" + employee.calculateAnnualSalary() + "\n");
        });
    }

    private void displayProducts() {
        outputTextArea.append("Products:\n");
        managementSystem.getAllProductsFromDatabase().forEach(product -> {
            outputTextArea.append(product.toString() + "\n");
        });
    }

    private void addEmployee() {
        String name = JOptionPane.showInputDialog(this, "Enter Employee Name:");
        String salaryStr = JOptionPane.showInputDialog(this, "Enter Employee Salary:");
    
        // Validate user input
        if (!Employee.isValidEmployeeData(name, salaryStr)) {
            displayErrorMessage("Invalid employee data. Please enter valid details.");
            return;
        }
    
        double salary = Double.parseDouble(salaryStr);
        Employee newEmployee = new Employee(0, name, salary);
    
        managementSystem.addEmployee(newEmployee);
        outputTextArea.append("Employee added: " + newEmployee.toString() + "\n");
    }
    
    private void addProduct() {
        String name = JOptionPane.showInputDialog(this, "Enter Product Name:");
        String priceStr = JOptionPane.showInputDialog(this, "Enter Product Price:");
        String quantityStr = JOptionPane.showInputDialog(this, "Enter Product Quantity:");
    
        // Validate user input
        if (!Product.isValidProductData(name, priceStr, quantityStr)) {
            displayErrorMessage("Invalid product data. Please enter valid details.");
            return;
        }
    
        double price = Double.parseDouble(priceStr);
        int quantity = Integer.parseInt(quantityStr);
        Product newProduct = new Product(0, name, price, quantity);
    
        managementSystem.addProduct(newProduct);
        outputTextArea.append("Product added: " + newProduct.toString() + "\n");
    }

    // Method to display error message in a JOptionPane
    private void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void updateEmployee() {
        int employeeId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Employee ID to Update:"));
        String name = JOptionPane.showInputDialog(this, "Enter New Employee Name:");
        double salary = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter New Employee Salary:"));
        Employee updatedEmployee = new Employee(employeeId, name, salary);

        // Perform the update in the database
        // You need to implement the updateEmployeeInDatabase method in your EmployeeStockManagement class
        managementSystem.updateEmployeeInDatabase(updatedEmployee);

        outputTextArea.append("Employee updated: " + updatedEmployee.toString() + "\n");
    }

    private void updateProduct() {
        int productId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Product ID to Update:"));
        String name = JOptionPane.showInputDialog(this, "Enter New Product Name:");
        double price = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter New Product Price:"));
        int quantity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter New Product Quantity:"));
        Product updatedProduct = new Product(productId, name, price, quantity);

        // Perform the update in the database
        // You need to implement the updateProductInDatabase method in your EmployeeStockManagement class
        managementSystem.updateProductInDatabase(updatedProduct);

        outputTextArea.append("Product updated: " + updatedProduct.toString() + "\n");
    }

    private static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
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

        // Display all employees and products
        displayAllEmployeesAndProducts(managementSystem);


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeStockManagementGUI().setVisible(true);
            }
        });
    }

    // JDBC Connection parameters
    static final String DB_URL = "jdbc:mysql://localhost/MartDB";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static final String DATABASE_NAME = "MartDB";

    // Create Employee table SQL
    private static final String CREATE_EMPLOYEE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS employees (" +
            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
            "name TEXT NOT NULL," +
            "salary DOUBLE NOT NULL)";

    // Create Product table SQL
    private static final String CREATE_PRODUCT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS products (" +
            "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
            "name TEXT NOT NULL," +
            "price DOUBLE NOT NULL," +
            "quantity INTEGER NOT NULL)";

    // Method to initialize the database
    private static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
             Statement statement = connection.createStatement()) {

            // Create Employee table
            statement.executeUpdate(CREATE_EMPLOYEE_TABLE_SQL);

            // Create Product table
            statement.executeUpdate(CREATE_PRODUCT_TABLE_SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display all employees and products
    private static void displayAllEmployeesAndProducts(EmployeeStockManagement managementSystem) {
        System.out.println("All Employees:");
        List<Employee> allEmployees = managementSystem.getAllEmployeesFromDatabase();
        allEmployees.forEach(System.out::println);

        System.out.println("\nAll Products:");
        List<Product> allProducts = managementSystem.getAllProductsFromDatabase();
        allProducts.forEach(System.out::println);
    }
    

}
