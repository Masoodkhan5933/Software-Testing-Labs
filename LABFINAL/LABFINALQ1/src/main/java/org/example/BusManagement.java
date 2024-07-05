package org.example;

public class BusManagement {

    private static final int MAX_PASSENGERS = 5;
    private Passenger[] passengers = new Passenger[MAX_PASSENGERS];
    private int numPassengers = 0;

    public static void main(String[] args) {
        BusManagement busManagement = new BusManagement();

        System.out.println("--------------------UNIVERSITY BUS MANAGEMENT--------------------\n");

        System.out.println(busManagement.addPassenger("irfan", 12));
        System.out.println(busManagement.addPassenger("karar", 6));
        System.out.println(busManagement.addPassenger("Neelab", 3));
        System.out.println(busManagement.addPassenger("ijlal", 5));
        System.out.println(busManagement.addPassenger("Ali", 1));
        System.out.println(busManagement.addPassenger("uzair", 10));

        System.out.println(busManagement.addPassenger("", 2));
        System.out.println(busManagement.addPassenger("Ahmed", -1));

        System.out.println(busManagement.addPassenger("Aisha", 3));
    }

    public String addPassenger(String name, int id) {
        if (numPassengers >= MAX_PASSENGERS) {
            return "Bus is full";
        }

        if (name == null || name.isEmpty()) {
            return "Invalid name";
        }

        if (id <= 0) {
            return "Invalid ID";
        }

        for (int i = 0; i < numPassengers; i++) {
            if (passengers[i].id == id) {
                return "Duplicate ID";
            }
        }

        Passenger passenger = new Passenger(name, id);
        passengers[numPassengers] = passenger;
        numPassengers++;
        passenger.markAttendance();
        return "Passenger added. Attendance marked for " + name + " with id " + id;
    }

    private class Passenger {
        String name;
        int id;
        boolean attended;

        public Passenger(String name, int id) {
            this.name = name;
            this.id = id;
            this.attended = false;
        }

        public void markAttendance() {
            this.attended = true;
        }
    }
}
