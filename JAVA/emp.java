public class emp {
    private static final double BASE_SALARY_RAISE_PERCENTAGE = 5.0;

    private String employeeName;
    private double baseSalary;

    public emp(String employeeName, double baseSalary) {
        this.employeeName = employeeName;
        this.baseSalary = baseSalary;
    }

    public static void displayBaseSalaryRaisePercentage() {
        System.out.println("Base Salary Raise Percentage: " + BASE_SALARY_RAISE_PERCENTAGE + "%");
    }

    public final double calculateTotalSalary(double bonus) {
        double totalSalary = baseSalary + bonus;
        // Apply the static base salary raise percentage
        totalSalary *= (1 + BASE_SALARY_RAISE_PERCENTAGE / 100);
        return totalSalary;
    }

    public static void main(String[] args) {
        emp e1 = new emp("Harsha", 23000);
        e1.displayBaseSalaryRaisePercentage();
        System.out.println("Salary after raise is" + e1.calculateTotalSalary(50000));
    }

}
