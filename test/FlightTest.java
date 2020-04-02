package flight.system.test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import flight.system.Airline;
import flight.system.Airplane;
import flight.system.Airport;
import flight.system.Flight;

public class FlightTest {

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIllegalArgumentExceptionWhenDefaultConstructorIsInvokedWithIllegalTime() throws CloneNotSupportedException {
        Flight test = new Flight(new Airline("Aeroflot", "Russia"),
                new Airplane("Boeing17", "AMx4", 120, 65),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("Sheremetievo", "SHE", "Moscow", "Russia",
                        (byte) 2),
                LocalTime.now(), LocalTime.of(10, 45), 150);
    }

    @Test
    public void testGetCode() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetOperator() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetOperator() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetAirplane() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetAirplane() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetDeptAirport() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetDeptAirport() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetArrvAirport() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetArrvAirport() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetDeptTime() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetDeptTime() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetArrvTime() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetArrvTime() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetFlightTime() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetFlightTime() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetFlightKm() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetFlightKm() {
        fail("Not yet implemented");
    }

    @Test
    public void testCompareTo() {
        fail("Not yet implemented");
    }

}
