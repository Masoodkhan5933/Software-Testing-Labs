package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BusManagementTest {

    private BusManagement busManagement;

    @BeforeEach
    public void setUp() {
        busManagement = new BusManagement();
    }

    @Test
    public void ValidNameAndID() {
        String result = busManagement.addPassenger("irfan", 1);
        assertEquals("Passenger added. Attendance marked for irfan with id 1", result);
    }

    @Test
    public void EmptyName() {
        String result = busManagement.addPassenger("", 2);
        assertEquals("Invalid name", result);
    }

    @Test
    public void NullName() {
        String result = busManagement.addPassenger(null, 3);
        assertEquals("Invalid name", result);
    }

    @Test
    public void NegativeID() {
        String result = busManagement.addPassenger("Ahmed", -1);
        assertEquals("Invalid ID", result);
    }

    @Test
    public void ZeroID() {
        String result = busManagement.addPassenger("Ahmed", 0);
        assertEquals("Invalid ID", result);
    }

    @Test
    public void ValidBoundaryID() {
        String result = busManagement.addPassenger("Ali", 1);
        assertEquals("Passenger added. Attendance marked for Ali with id 1", result);
    }

    @Test
    public void BoundaryFull() {
        busManagement.addPassenger("irfan", 1);
        busManagement.addPassenger("karar", 2);
        busManagement.addPassenger("Neelab", 3);
        busManagement.addPassenger("ijlal", 4);
        String result = busManagement.addPassenger("Ali", 5);
        assertEquals("Passenger added. Attendance marked for Ali with id 5", result);
    }

    @Test
    public void OverFull() {
        busManagement.addPassenger("irfan", 1);
        busManagement.addPassenger("karar", 2);
        busManagement.addPassenger("Neelab", 3);
        busManagement.addPassenger("ijlal", 4);
        busManagement.addPassenger("Ali", 5);

        String result = busManagement.addPassenger("uzair", 6);
        assertEquals("Bus is full", result);
    }

    @Test
    public void DuplicateID() {
        busManagement.addPassenger("irfan", 1);
        String result = busManagement.addPassenger("karar", 1);
        assertEquals("Duplicate ID", result);
    }
}
