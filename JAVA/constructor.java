class employee {
    int empID = 0;
    String empName = "";
    float Salary = 0;
    String City;
    int yearsOfExperience = 0;

    // constructor
    employee() {
        System.out.println("Unorganised Employee Has been created");
        this.empName = "Unorganised";
    }

    // constructor with parameters
    employee(int id, String name) {
        this.empID = id;
        this.empName = name;
        System.out.println("Employee has been created with the ID:" + id + " and Name:" + name);
    }

    // constructor overloading
    employee(int id, String name, float salary) {
        this.empID = id;
        this.Salary = salary;
        this.empName = name;
        System.out.println("Employee name:" + name + "\n EmpID:" + id + "\nSalary:" + salary);
    }

    // normal method
    public void setSalary(float salary) {
        this.Salary = salary;
    }

    public void setName(String name) {
        this.empName = name;
    }

    public void setID(int id) {
        this.empID = id;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public void setExperience(int exp) {
        this.yearsOfExperience = exp;
    }

    public void getdetails() {
        System.out.println("Name:" + this.empName + "\nID" + this.empID + "\nSalary:" + this.Salary + "\nCity:"
                + this.City + "\nExperience:" + this.yearsOfExperience);
    }
}

public class constructor {
    public static void main(String[] args) {
        employee suresh = new employee();
        employee ramesh = new employee(1, "Ramesh");
        employee kalesh = new employee(2, "Kalesh", 23000);
        suresh.setCity("Bangalore");
        suresh.setExperience(1);
        suresh.setID(3);
        suresh.setName("Suresh");
        suresh.setSalary(20000);
        suresh.getdetails();
        ramesh.getdetails();
        kalesh.getdetails();
    }
}
