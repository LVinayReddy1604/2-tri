class Employee {
    private String name;
    private int empId;
    private Salary salary;
    private Address address;

    public Employee(String name, int empId, double basicSalary, String city, String state, String country) {
        this.name = name;
        this.empId = empId;
        this.salary = new Salary(basicSalary);
        this.address = new Address(city, state, country);
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + salary.getBasicSalary());
        System.out.println("Total Salary: " + salary.calculateTotalSalary());
        System.out.println("Salary Details: " + salary.getSalaryDetails());
        System.out.println("Address: " + address.getFullAddress());
    }

    class Salary {
        private double basicSalary;
        private double bonus;
        private double allowance;
        private StringBuffer salaryDetails;

        public Salary(double basicSalary) {
            this.basicSalary = basicSalary;
            this.bonus = 0.0;
            this.allowance = 0.0;
            this.salaryDetails = new StringBuffer("Basic: " + basicSalary);
        }

        public double getBasicSalary() {
            return basicSalary;
        }

        public double calculateTotalSalary() {
            bonus = basicSalary * 0.1;
            allowance = basicSalary * 0.2;

            double totalSalary = basicSalary + bonus + allowance;
            salaryDetails.append(", Bonus: " + bonus);
            salaryDetails.append(", Allowance: " + allowance);

            return totalSalary;
        }

        public String getSalaryDetails() {
            return salaryDetails.toString();
        }
    }

    static class Address {
        private String city;
        private String state;
        private String country;

        public Address(String city, String state, String country) {
            this.city = city;
            this.state = state;
            this.country = country;
        }

        public String getFullAddress() {
            return city + ", " + state + ", " + country;
        }
    }
}

public class lab3 {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 101, 50000.0, "New York", "NY", "USA");
        employee.displayDetails();
    }
}
