package myapp;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("java.lang.String");
            Method[] methods = cls.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
