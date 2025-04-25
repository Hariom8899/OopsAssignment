package q2_Vehicle;

public class Car extends Vehicle {
    public Car(double speed, double fuelCapacity) {
        super(speed, fuelCapacity);
    }

    // Mileage formula for Car: (speed * 0.5) / fuelCapacity
    public double getMileage() {
        return (speed * 5) / fuelCapacity;
    }
}

