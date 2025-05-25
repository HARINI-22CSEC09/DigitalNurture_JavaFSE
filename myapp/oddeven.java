package myapp;

import java.util.Scanner;

public class oddeven {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        if (number % 2 == 0)
            System.out.println("Even number");
        else
            System.out.println("Odd number");
        sc.close();
}
}