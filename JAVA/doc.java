class Doctor {
    Doctor() {
        System.out.println("Doctor created");
    }

    Doctor(int a) {
        System.out.println("Doctor created" + a);
    }
}

class Nurse extends Doctor {
    Nurse(int a, int b) {
        // super(0);
        System.out.println("Nurse created" + a + "" + b);
    }

    void Doctor() {
        System.out.println("Doctor created");
    }
}

public class doc {
    public static void main(String[] args) {
        // Nurse n = new Nurse(2, 3);
        Nurse d = new Nurse(3, 4);
        d.Doctor();
    }
}
