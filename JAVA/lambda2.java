import java.util.ArrayList;
import java.util.function.Consumer;

interface NumberFinder {
    int finder(int number1, int number2);
}

public class lambda2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(1);
        numbers.forEach((n) -> {
            System.out.println(n);
        });
        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(9);
        numbers2.add(5);
        numbers2.add(8);
        numbers2.add(1);
        Consumer<Integer> method = (n) -> {
            System.out.println(n);
        };
        numbers2.forEach(method);
        NumberFinder numberFinder = (number1, number2) -> {
            int temp = 0;
            if (number1 > number2) {
                temp = number1;
            } else {
                temp = number2;
            }
            return temp; // explicitly return a value
        };
        System.out.println("The valus is: " + numberFinder.finder(10, 5));
    }
}
