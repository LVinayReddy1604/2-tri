interface EmpInfo {
    void setEmpDetails(String name, int empID);

    void dispEmpDetails();
}

interface SalCal {
    void calBasicSal();

    void calBonus();
}

interface PayProcess {
    void payProcess();

    void genSlip();
}

class PayrollProcessor implements PayProcess {
    public void payProcess() {
        System.out.println("Payroll processed successfully.");
    }

    public void genSlip() {
        System.out.println("Payslip generated successfully.");
    }
}

class Employee implements EmpInfo, SalCal {
    private String name;
    private int empID;
    private double basicSalary;
    private double bonus;

    public Employee() {
        this.name = "";
        this.empID = 0;
        this.basicSalary = 0.0;
        this.bonus = 0.0;
    }

    public void setEmpDetails(String name, int empID) {
        this.name = name;
        this.empID = empID;
    }

    public void dispEmpDetails() {
        System.out.println("Employee: " + name + ", ID: " + empID + ", BasicSal:" + basicSalary + ", Bonus:" + bonus);
    }

    public void calBasicSal() {
        basicSalary = 50000;
        System.out.println("Basic Salary calculated: " + basicSalary);
    }

    public void calBonus() {
        // Logic for calculating bonus
        bonus = 10000;
        System.out.println("Bonus calculated: " + bonus);
    }
}

class SalaryManagementSystem implements EmpInfo, SalCal, PayProcess {
    private Employee employee;
    private PayrollProcessor payrollProcessor;

    public SalaryManagementSystem() {
        employee = new Employee();
        payrollProcessor = new PayrollProcessor();
    }

    public void setEmpDetails(String name, int empID) {
        employee.setEmpDetails(name, empID);
    }

    public void dispEmpDetails() {
        employee.dispEmpDetails();
    }

    public void calBasicSal() {
        employee.calBasicSal();
    }

    public void calBonus() {
        employee.calBonus();
    }

    public void payProcess() {
        System.out.println("Processing payroll for employee...");
        calBasicSal();
        calBonus();
        System.out.println("Payroll processing completed.");
    }

    public void genSlip() {
        System.out.println("Generating payslip for employee...");
        dispEmpDetails();
        System.out.println("Payslip generated successfully.");
    }
}

public class lab4 {
    public static void main(String[] args) {
        SalaryManagementSystem s1 = new SalaryManagementSystem();
        s1.setEmpDetails("L Vinay", 2347126);
        s1.dispEmpDetails();
        s1.payProcess();
        s1.genSlip();

        System.out.println("\n");

        SalaryManagementSystem s2 = new SalaryManagementSystem();
        s2.setEmpDetails("Kumar", 2347125);
        s2.dispEmpDetails();
        s2.payProcess();
        s2.genSlip();
    }
}
