package q2_Vehicle;

public class Vehicle {
    protected double speed;
    protected double fuelCapacity;

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

