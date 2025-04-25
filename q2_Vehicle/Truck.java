package q2_Vehicle;

public class Truck extends Vehicle {
    public Truck(double speed, double fuelCapacity) {
        super(speed, fuelCapacity);
    }

    // Mileage formula for Truck: (speed * 0.3) / (fuelCapacity * 1.2)
    public double getMileage() {
        return (speed * 0.3) / (fuelCapacity * 1.2);
    }
}

