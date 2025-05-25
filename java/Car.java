package java;

public class Car {
    String make;
    String model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayDetails() {
        System.out.println("Car: " + make + " " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020);
        car1.displayDetails();
    }
}

