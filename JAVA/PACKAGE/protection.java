package PACKAGE;

public class protection {
    int n = 1;
    private int n_pri = 2;
    protected int n_pro = 3;
    public int n_pub = 4;

    public protection() {
        System.out.println("Base Constructor");
        System.out.println("n:" + n);
        System.out.println("n_pri:" + n_pri);
        System.out.println("n_pri:" + n_pro);
        System.out.println("n_pri:" + n_pub);

    }
}
