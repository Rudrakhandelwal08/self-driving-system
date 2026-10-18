public class Car extends Vehicle {
    private String fuelType;
    private int seats;

    public Car(int id, String brand, String model, double rent,
               String fuel, int seats) {
        super(id, brand, model, rent);
        fuelType = fuel;
        this.seats = seats;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fuel: " + fuelType + " | Seats: " + seats);
        if (isAvailable()) System.out.println("Status: Available");
        else System.out.println("Status: Booked");
        System.out.println("---------------------------");
    }
}
