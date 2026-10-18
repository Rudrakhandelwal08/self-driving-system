public class Billing {
    private double penaltyPerDay = 500;

    public void generateBill(Customer customer, int returnDay) {
        Car car = customer.getBookedCar();
        if (car == null) {
            System.out.println("No active booking.");
            return;
        }
        if (returnDay < customer.getBookingDay()) {
            System.out.println("Return day cannot be before booking day.");
            return;
        }

        int dueDay = customer.getBookingDay() + customer.getRentalDays();
        int lateDays = returnDay - dueDay;
        if (lateDays < 0) lateDays = 0;

        double rent = car.getRentPerDay() * customer.getRentalDays();
        double penalty = lateDays * penaltyPerDay;
        System.out.println("\n========= FINAL BILL =========");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car ID: " + car.getVehicleId());
        System.out.println("Booking day: " + customer.getBookingDay());
        System.out.println("Due day: " + dueDay);
        System.out.println("Return day: " + returnDay);
        System.out.println("Rent: Rs." + rent);
        System.out.println("Late days: " + lateDays);
        System.out.println("Penalty: Rs." + penalty);
        System.out.println("Total: Rs." + (rent + penalty));
        System.out.println("==============================");
        car.setAvailable(true);
        customer.clearBooking();
        System.out.println("Car returned successfully.");
    }
}
