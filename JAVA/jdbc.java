import java.sql.*;

public class jdbc {

    static final String DB_URL = "jdbc:mysql://localhost/3306";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Initialize the database with some employee records
            initializeDatabase(statement);

            // Perform CRUD operations
            // (You can replace these with your specific operations)

            // Read (Retrieve) operation
            readData(statement);

            // Create operation
            createData(statement, "John Doe", 60000.0, "IT");

            // Update operation
            updateData(statement, 1, 65000.0);

            // Delete operation
            deleteData(statement, 3);

            // Close connections
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeDatabase(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS employee_salary_management");
        statement.executeUpdate("USE employee_salary_management");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "salary DOUBLE NOT NULL," +
                "department VARCHAR(50) NOT NULL)");

        // Insert some initial employee records
        statement.executeUpdate("INSERT INTO employees (name, salary, department) VALUES " +
                "('Alice Smith', 70000.0, 'HR'), " +
                "('Bob Johnson', 80000.0, 'Finance'), " +
                "('Charlie Brown', 60000.0, 'IT'), " +
                "('David Wilson', 75000.0, 'Marketing'), " +
                "('Eva Davis', 90000.0, 'Engineering'), " +
                "('Frank Miller', 65000.0, 'Sales'), " +
                "('Grace Taylor', 72000.0, 'Finance'), " +
                "('Henry Harris', 68000.0, 'IT'), " +
                "('Ivy Jones', 95000.0, 'Engineering'), " +
                "('Jack Anderson', 85000.0, 'HR')");
    }

    private static void readData(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                    ", Name: " + resultSet.getString("name") +
                    ", Salary: " + resultSet.getDouble("salary") +
                    ", Department: " + resultSet.getString("department"));
        }
        resultSet.close();
    }

    private static void createData(Statement statement, String name, double salary, String department) throws SQLException {
        statement.executeUpdate("INSERT INTO employees (name, salary, department) VALUES " +
                "('" + name + "', " + salary + ", '" + department + "')");
        System.out.println("Employee record created successfully.");
    }

    private static void updateData(Statement statement, int id, double newSalary) throws SQLException {
        statement.executeUpdate("UPDATE employees SET salary = " + newSalary + " WHERE id = " + id);
        System.out.println("Employee record updated successfully.");
    }

    private static void deleteData(Statement statement, int id) throws SQLException {
        statement.executeUpdate("DELETE FROM employees WHERE id = " + id);
        System.out.println("Employee record deleted successfully.");
    }
}
 