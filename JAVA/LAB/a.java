import java.util.Scanner;

class Employee {
    String name;
    double baseSalary;
    String employmentType;

    public Employee(String name, double baseSalary, String employmentType) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.employmentType = employmentType;
    }
}

class SalaryCalculator implements Runnable {
    private Employee employee;

    public SalaryCalculator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void run() {
        double bonus = calculateBonus(employee.employmentType);
        double tax = calculateTax(employee.baseSalary);
        double totalSalary = employee.baseSalary + bonus - tax;

        System.out.println("Employee: " + employee.name + ", Base Salary: " + employee.baseSalary +
                ", Bonus: " + bonus + ", Tax: " + tax + ", Total Salary: " + totalSalary);
    }

    private double calculateBonus(String employmentType) {
        if ("full-time".equals(employmentType)) {
            return Math.random() * 1500;
        } else if ("part-time".equals(employmentType)) {
            return Math.random() * 800;
        } else {
            return 0;
        }
    }

    private double calculateTax(double baseSalary) {
        return baseSalary * 0.15;
    }
}

public class a {
    public static void main(String[] args) {
        int n = 0;
        String name, etype;
        Double bsal;
        Employee[] employees = new Employee[20];
        System.out.println("Enter the number of employees");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of employee " + (i + 1));
            name = sc.next();
            System.out.println("Enter the Basic Salary for " + name);
            bsal = sc.nextDouble();
            System.out.println("Enter the Employee Type of " + name + "(full-time/part-time)");
            etype = sc.next();
            employees[i] = new Employee(name, bsal, etype);
        }
        sc.close();

        Thread[] threads = new Thread[employees.length];
        for (int i = 0; i < employees.length; i++) {
            Runnable task = new SalaryCalculator(employees[i]);
            threads[i] = new Thread(task);
            threads[i].start();
        }
    }
}

class Employee {
    String name;
    double baseSalary;
    String employmentType;

    public Employee(String name, double baseSalary, String employmentType) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.employmentType = employmentType;
    }
}

class SalaryCalculator implements Runnable {
    private Employee employee;

    public SalaryCalculator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void run() {
        // Set thread priority based on employment type
        int priority = calculateThreadPriority(employee.employmentType);
        Thread.currentThread().setPriority(priority);

        // Simulate a time-consuming calculation, e.g., calculating bonuses
        double bonus = calculateBonus(employee.employmentType);
        double tax = calculateTax(employee.baseSalary);
        double totalSalary = employee.baseSalary + bonus - tax;

        System.out.println("Employee: " + employee.name + ", Base Salary: " + employee.baseSalary +
                ", Bonus: " + bonus + ", Tax: " + tax + ", Total Salary: " + totalSalary +
                ", Thread Priority: " + Thread.currentThread().getPriority());
    }

    private double calculateBonus(String employmentType) {
        if ("full-time".equals(employmentType)) {
            return Math.random() * 1500;
        } else if ("part-time".equals(employmentType)) {
            return Math.random() * 800;
        } else {
            return 0;
        }
    }

    private double calculateTax(double baseSalary) {
        // Simulate a simple tax calculation
        return baseSalary * 0.15;
    }

    private int calculateThreadPriority(String employmentType) {
        // Assign higher priority to full-time employees
        return "full-time".equals(employmentType) ? Thread.MIN_PRIORITY : Thread.NORM_PRIORITY;
    }
}

public class Lab5 {
    public static void main(String[] args) {
        int n = 0;
        String name, etype;
        Double bsal;
        Employee[] employees = new Employee[20];
        System.out.println("Enter the number of employees");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of employee " + (i + 1));
            name = sc.next();
            System.out.println("Enter the Basic Salary for " + name);
            bsal = sc.nextDouble();
            System.out.println("Enter the Employee Type of " + name + "(full-time/part-time)");
            etype = sc.next();
            employees[i] = new Employee(name, bsal, etype);
        }
        sc.close();
        Thread[] threads = new Thread[employees.length];
        for (int i = 0; i < employees.length; i++) {
            Runnable task = new SalaryCalculator(employees[i]);
            threads[i] = new Thread(task);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}