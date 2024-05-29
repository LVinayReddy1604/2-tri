interface Med {
    void medication(String med);

    void surgery(String surg);
}

interface Doc {
    void Doctor(String doc);
}

class c1 implements Med, Doc {
    @Override
    public void medication(String med) {
        System.out.println(med);
    }

    @Override
    public void surgery(String surg) {
        System.out.println(surg);
    }

    @Override
    public void Doctor(String doc) {
        System.out.println(doc);
    }
}

public class sup {
    public static void main(String[] args) {
        c1 obj = new c1();
        obj.Doctor("Dr.John");
        obj.medication("Medicine");
        obj.surgery("Surgery");
    }
}