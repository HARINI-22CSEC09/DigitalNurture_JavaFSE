package myapp; 

import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student name: ");
            names.add(sc.nextLine());
        }

        System.out.println("Student names:");
        for (String name : names) {
            System.out.println(name);
        }
        sc.close();
    }
}
