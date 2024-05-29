class Employee {
    float salary = 4000;
}

class BankProgrammer extends Employee {
    int increment = 10000;
    float updatedSalary = salary + increment;

    public static void main(String[] args) {
        BankProgrammer bp = new BankProgrammer();
        System.out.println("Programmer Salary is:" + bp.salary);
        System.out.println("Increment of programmer is:" + bp.increment);
        System.out.println("Updated Salary of programmer is:" + bp.updatedSalary);
    }
}