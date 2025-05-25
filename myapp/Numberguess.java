package myapp;
import java.util.Scanner;
import java.util.Random;

public class Numberguess {
    

    public static void main(String[] args) {
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess = 0;

        while (guess != target) {
            System.out.print("Guess the number (1-100): ");
            guess = sc.nextInt();

            if (guess < target) {
                System.out.println("Too low!");
            } else if (guess > target) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! The number was " + target);
            }
        }
        sc.close();
    }
}

