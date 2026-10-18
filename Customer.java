public class Customer {
    private int id, rentalDays, bookingDay;
    private String name, phone, license;
    private Car bookedCar;

    public Customer(int id, String name, String phone, String license) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.license = license;
        bookedCar = null;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Car getBookedCar() { return bookedCar; }
    public int getRentalDays() { return rentalDays; }
    public int getBookingDay() { return bookingDay; }

    public void book(Car car, int days, int day) {
        bookedCar = car;
        rentalDays = days;
        bookingDay = day;
        car.setAvailable(false);
        System.out.println("Booking successful!");
    }

    public void cancel() {
        if (bookedCar == null) {
            System.out.println("No active booking.");
            return;
        }
        bookedCar.setAvailable(true);
        clearBooking();
        System.out.println("Booking cancelled.");
    }

    public void clearBooking() {
        bookedCar = null;
        rentalDays = 0;
        bookingDay = 0;
    }

    public void display() {
        System.out.println("Customer ID: " + id + " | Name: " + name);
        System.out.println("Phone: " + phone + " | License: " + license);
        if (bookedCar == null) System.out.println("No active booking");
        else System.out.println("Booked car ID: " + bookedCar.getVehicleId());
    }
}
