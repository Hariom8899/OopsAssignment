package q2_Vehicle;

public class Vehicle {
    protected double speed;         // in km/h
    protected double fuelCapacity;  // in liters

    public Vehicle(double speed, double fuelCapacity) {
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
    }

    // Getter methods
    public double getSpeed() {
        return speed;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }
}

