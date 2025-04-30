package q13_FlightBookingManager;

import java.util.*;

public class FlightBookingManager {
    // Map to store confirmed bookings: customer -> seat number
    private static Map<String, Integer> confirmedBookings = new HashMap<>();

    // Queue to store incoming booking requests
    private static Queue<String> bookingQueue = new LinkedList<>();

    // Simulate available seat numbers
    private static int nextSeatNumber = 1;

    public static void main(String[] args) {
        // Simulate incoming booking requests
        addBookingRequest("Alice");
        addBookingRequest("Bob");
        addBookingRequest("Charlie");

        // Process the booking requests
        processBookings();

        // Display confirmed bookings with seat numbers
        displayConfirmedBookings();
    }

    // Add a booking request to the queue
    public static void addBookingRequest(String customerName) {
        bookingQueue.offer(customerName);
        System.out.println("Booking request received for: " + customerName);
    }

    // Process bookings FIFO and assign seat numbers
    public static void processBookings() {
        while (!bookingQueue.isEmpty()) {
            String customerName = bookingQueue.poll(); // Get the next booking request
            int seatNumber = nextSeatNumber++; // Assign the next available seat number
            confirmedBookings.put(customerName, seatNumber); // Store the confirmed booking with seat number
            System.out.println("Booking confirmed for " + customerName + " with seat number " + seatNumber);
        }
    }

    // Display the confirmed bookings with seat numbers
    public static void displayConfirmedBookings() {
        System.out.println("\nConfirmed Bookings:");
        for (Map.Entry<String, Integer> entry : confirmedBookings.entrySet()) {
            System.out.println(entry.getKey() + " - Seat Number: " + entry.getValue());
        }
    }
}


