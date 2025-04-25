package q2_Vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(120, 40);
        Truck truck = new Truck(80, 100);

        System.out.println("Car mileage: " + car.getMileage() + " km/l");
        System.out.println("Truck mileage: " + truck.getMileage() + " km/l");
    }
}

