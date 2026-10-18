public class Vehicle {
    private int vehicleId;
    private String brand, model;
    private double rentPerDay;
    private boolean available;

    public Vehicle(int id, String brand, String model, double rent) {
        vehicleId = id;
        this.brand = brand;
        this.model = model;
        rentPerDay = rent;
        available = true;
    }

    public int getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getRentPerDay() { return rentPerDay; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean value) { available = value; }

    public void displayDetails() {
        System.out.println("ID: " + vehicleId + " | " + brand + " " + model);
        System.out.println("Rent per day: Rs." + rentPerDay);
    }
}
