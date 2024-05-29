class medinfo1 {
    public void treatment() {
        System.out.println("Heart surgery");
    }
}

class medinfo2 extends medinfo1 {
    public void treatment() {
        System.out.println("Intestine surgery");
    }
}

class medinfo3 extends medinfo2 {
    public void treatment() {
        System.out.println("Laser surgery");
    }
}

class dispatch {
    public static void main(String[] args) {
        medinfo1 obj1 = new medinfo1();
        medinfo2 obj2 = new medinfo2();
        medinfo3 obj3 = new medinfo3();

        medinfo1 dispatch;
        dispatch = obj1;
        dispatch.treatment();
        dispatch = obj2;
        dispatch.treatment();
        dispatch = obj3;
        dispatch.treatment();

    }
}