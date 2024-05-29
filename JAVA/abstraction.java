abstract class Bank {
    abstract int getRateOfInterest();
}

class SBI {
    public int getRateOfInterest() {
        return 7;
    }
}

class ICICI extends Bank {
    public int getRateOfInterest() {
        return 8;
    }
}

public class abstraction {
    public static void main(String[] args) {
        SBI a = new SBI();
        Bank b = new ICICI(); // dynamic dispatch
        int SBIinterest = a.getRateOfInterest();
        System.out.println("SBI Bank Interest rate is: " + SBIinterest + "%");
        int ICICIinterest = b.getRateOfInterest();

        System.out.println("ICICI Bank Interest rate is: " + ICICIinterest + "%");
    }
}
