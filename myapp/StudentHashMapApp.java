package myapp; 

import java.util.HashMap;
import java.util.Scanner;

public class StudentHashMapApp {

    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume the newline
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
        }

        System.out.print("Enter student ID to retrieve: ");
        int searchId = sc.nextInt();
        String result = studentMap.get(searchId);

        if (result != null) {
            System.out.println("Student Name: " + result);
        } else {
            System.out.println("ID not found.");
        }

        sc.close();
    }
}
