package myapp;

public class Typecast {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble;

        int anotherInt = 5;
        double anotherDouble = anotherInt;

        System.out.println("Double to int: " + myInt);
        System.out.println("Int to double: " + anotherDouble);
    }
}
