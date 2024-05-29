class test<T> {
    T obj;

    test(T obj) {
        this.obj = obj;
    }

    public void disp() {
        System.out.println(obj);
    }
}

class test1<t, jj> {
    t obj1;
    jj obj2;

    test1(t obj1, jj obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    void print() {
        System.out.println(obj1 + "\n" + obj2);
    }
}

public class generics {
    public static void main(String[] args) {
        test<Integer> obj1 = new test<Integer>(2983);
        obj1.disp();

        test1<Integer, String> obj2 = new test1<Integer, String>(24, "string");
        obj2.print();
    }
}
