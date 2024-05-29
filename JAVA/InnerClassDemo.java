class Outer {
    int outer_x = 100;
    int y = 20;

    void test() {
        InnerClass i1 = new InnerClass();
        i1.Display();
        i1.Show();
    }

    class InnerClass {
        int y = 10;

        void Display() {
            System.out.println("Display: Outer_x= " + outer_x);
        }

        void Show() {
            System.out.println(y);
        }
    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
        Outer o = new Outer();
        o.test();
    }
}