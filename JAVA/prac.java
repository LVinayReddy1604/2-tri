// 1. Write a Java program to display the time in human readable format like,
// hours:minutes:seconds.

// 2. Write a Java program to split a sentence in to array with the space delimiter.
// “Betty bought some butter”

// 3. Demonstrate Compile time Polymorphism and Run-time Polymorphism.

// 4. Tell Me Why
// public class Client1 {
// static void doCalc(byte... a) {
// System.out.print("byte...");
// }
// static void doCalc(long a, long b) {
// System.out.print("long, long");
// }
// static void doCalc(Byte s1, Byte s2) {
// System.out.print("Byte, Byte");
// }
// public static void main (String[] args) {
// byte b = 5;
// doCalc(b, b);
// }
// }

// 5. What gets printed on the standard output when the class below is compiled and executed.
// public class ShortCkt
// {
// public static void main(String args[])
// {
// int i = 0;
// boolean t = true;
// boolean f = false, b;
// b = (t | ((i++) == 0));
// b = (f | ((i+=2) &gt; 0));
// System.out.println(i);
// }
// }
// 6. What gets displayed on the screen when the following program is compiled and run.
// public class test
// {
// public static void main(String args[])
// {
// boolean x = true;
// int a;

// if(x) a = x ? 1: 2;
// else a = x ? 3: 4;
// System.out.println(a);
// }
// }

// 7. What is the result when this code is executed?
// class One {
// public One() { System.out.print(1); }
// }
// class Two extends One {
// public Two() { System.out.print(2); }
// }
// class Three extends Two {
// public Three() { System.out.print(3); }
// }
// public class Numbers{
// public static void main( String[] argv ) { new Three(); }
// }

// 8. What all gets printed when the following program is compiled and run.
// public class test
// {
// public static void main(String args[])
// {
// int i=0, j=2;
// do
// {
// i=++i;
// j--;
// }
// while(j&gt;0);
// System.out.println(i);
// }
// }

// 9. What all gets printed when the following gets compiled and run.
// public class test {
// public static void main(String args[]) {
// String s1 = "abc";
// String s2 = new String("abc");
// if(s1 == s2)
// System.out.println(1);

// else
// System.out.println(2);
// if(s1.equals(s2))
// System.out.println(3);
// else
// System.out.println(4);
// }
// }

// 10. What is the result?
// public static void test(String str)
// {
// int check = 4;
// if (check = str.length())
// {
// System.out.print(str.charAt(check -= 1) +", ");
// }
// else
// {
// System.out.print(str.charAt(0) + ", ");
// }
// }
// and the invocation:
// 21. test("four");
// 22. test("tee");
// test("to");

// // 11. How many String objects will be created when this method is invoked?
// public String makinStrings()
// {
// String s = “Fred”;
// s = s + “47”;
// s = s.substring(2, 5);
// s = s.toUpperCase();
// return s.toString();
// }

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Dog extends Animal {

    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class One {
    public One() {
        System.out.print(1);
    }
}

class Two extends One {
    public Two() {
        System.out.print(2);
    }
}

class Three extends Two {
    public Three() {
        System.out.print(3);
    }

}

public class prac {
    public static void test(String str) {
        int check = 4;
        if (check == str.length()) {
            System.out.print(str.charAt(check -= 1) + ", ");
        } else {
            System.out.print(str.charAt(0) + ", ");
        }
    }

    static void increment(int index) {
        index++;
    }

    public static void main(String[] args) {
        // 1.
        System.out.println("1.");
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        System.out.println("Current Time: " + formattedTime);

        // 2.
        System.out.println("2.");
        String sentence = "Betty bought some butter";
        String[] words = sentence.split(" ");
        System.out.println("Words in the sentence:");
        for (String word : words) {
            System.out.println(word);
        }

        // 3.
        System.out.println("3.");
        MathOperations mathOps = new MathOperations();
        System.out.println("Sum of two numbers: " + mathOps.add(10, 20));
        System.out.println("Sum of three numbers: " + mathOps.add(10, 20, 30));
        Animal genericAnimal = new Animal();
        Animal dog = new Dog();
        System.out.println("\nRun-time polymorphism:");
        System.out.print("Generic Animal sound: ");
        genericAnimal.makeSound();
        System.out.print("Dog sound: ");
        dog.makeSound();

        // 4.
        System.out
                .println("4. The query has metod overloading with different parameters and different parameter types");

        // 5.
        System.out.println("5.");
        int i = 0;
        boolean t = true;
        boolean f = false, b;
        b = (t | ((i++) == 0));
        b = (f | ((i += 2) > 0));
        System.out.println(i);

        // 6.
        System.out.println("6.");
        boolean x = true;
        int a;
        if (x)
            a = x ? 1 : 2;
        else
            a = x ? 3 : 4;
        System.out.println(a);

        // 7.
        System.out.println("7.");
        new Three();
        System.out.println();

        // 8.
        System.out.println("8.");
        i = 0;
        int j = 2;
        do {
            i = ++i;
            j--;
        } while (j > 0);
        System.out.println(i);

        // 9.
        System.out.println("9.");
        String s1 = "abc";
        String s2 = new String("abc");
        if (s1 == s2)
            System.out.println(1);

        else
            System.out.println(2);
        if (s1.equals(s2))
            System.out.println(3);
        else
            System.out.println(4);

        // 10.
        System.out.println("10.");
        test("four");
        test("tee");
        test("to");

        // 11.
        System.out.println();
        System.out.println("11.");
        String s = "Fred";
        s = s + "47";
        s = s.substring(2, 5);
        s = s.toUpperCase();
        System.out.println(s.toString());

        // 12.
        System.out.println("12.");
        Short ss1 = 200;
        Integer ss2 = 400;
        Long ss3 = (long) ss1 + ss2;
        // String s4=(String) (ss3*ss2);
        // System.out.println("Sum is"+ss4);
        System.out.println("Compilation fails at line n1");

        // 13.
        System.out.println("13.");
        System.out.println("A NullPointerException is thrown at runtime");

        // 14.
        System.out.println("14.");
        i = 0;
        increment(i);
        i++;
        System.out.println(i);

    }
}
