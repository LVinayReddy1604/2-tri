abstract class Department {
    abstract void Empdetails();
    abstract void payment();
}

class Sales extends Department {
    void Empdetails() {
        System.out.println("EMPName");
    }

    void payment() {
        System.out.println("Payment");
    }
}

public class Sample {
    public static void main(String[] args) {
        Department Dept = new Sales();
        Dept.Empdetails();
        Dept.payment();
    }
}
