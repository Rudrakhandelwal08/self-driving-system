import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Car> cars = new Vector<Car>();
        Vector<Customer> customers = new Vector<Customer>();
        Billing billing = new Billing();
        int choice = 0;

        while (choice != 8) {
            System.out.println("\n===== SELF DRIVING CAR RENTAL =====");
            System.out.println("1. Add car");
            System.out.println("2. Register customer");
            System.out.println("3. Show available cars");
            System.out.println("4. Book car");
            System.out.println("5. Cancel booking");
            System.out.println("6. Return car and bill");
            System.out.println("7. Show customers");
            System.out.println("8. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Car ID: ");
                int id = sc.nextInt();
                boolean exists = false;
                for (Car c : cars) if (c.getVehicleId() == id) exists = true;
                if (exists) { System.out.println("Car ID already exists."); continue; }
                sc.nextLine();
                System.out.print("Brand: "); String brand = sc.nextLine();
                System.out.print("Model: "); String model = sc.nextLine();
                System.out.print("Rent per day: "); double rent = sc.nextDouble();
                sc.nextLine();
                System.out.print("Fuel type: "); String fuel = sc.nextLine();
                System.out.print("Seats: "); int seats = sc.nextInt();
                if (rent <= 0 || seats <= 0) { System.out.println("Invalid rent or seats."); continue; }
                cars.add(new Car(id, brand, model, rent, fuel, seats));
                System.out.println("Car added.");
            } else if (choice == 2) {
                System.out.print("Customer ID: "); int id = sc.nextInt();
                boolean exists = false;
                for (Customer c : customers) if (c.getId() == id) exists = true;
                if (exists) { System.out.println("Customer ID already exists."); continue; }
                sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Phone: "); String phone = sc.nextLine();
                System.out.print("License: "); String license = sc.nextLine();
                customers.add(new Customer(id, name, phone, license));
                System.out.println("Customer registered.");
            } else if (choice == 3) {
                boolean found = false;
                for (Car car : cars) {
                    if (car.isAvailable()) { car.displayDetails(); found = true; }
                }
                if (!found) System.out.println("No cars available.");
            } else if (choice == 4 || choice == 5 || choice == 6) {
                System.out.print("Customer ID: "); int id = sc.nextInt();
                Customer customer = null;
                for (Customer c : customers) if (c.getId() == id) customer = c;
                if (customer == null) { System.out.println("Customer not found."); continue; }
                if (choice == 5) {
                    customer.cancel();
                } else if (choice == 6) {
                    if (customer.getBookedCar() == null) { System.out.println("No active booking."); continue; }
                    System.out.print("Actual return day number: "); int day = sc.nextInt();
                    billing.generateBill(customer, day);
                } else {
                    if (customer.getBookedCar() != null) { System.out.println("Customer already has a booking."); continue; }
                    System.out.print("Car ID: "); int carId = sc.nextInt();
                    Car car = null;
                    for (Car c : cars) if (c.getVehicleId() == carId) car = c;
                    if (car == null || !car.isAvailable()) { System.out.println("Car unavailable."); continue; }
                    System.out.print("Number of rental days: "); int days = sc.nextInt();
                    System.out.print("Booking day number: "); int day = sc.nextInt();
                    if (days <= 0 || day < 0) { System.out.println("Invalid days."); continue; }
                    customer.book(car, days, day);
                }
            } else if (choice == 7) {
                if (customers.isEmpty()) System.out.println("No customers.");
                for (Customer c : customers) c.display();
            } else if (choice == 8) {
                System.out.println("Thank you!");
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
