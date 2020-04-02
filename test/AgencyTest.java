package flight.system.test;

import static org.junit.Assert.*;

import org.junit.Test;

import flight.system.Agency;

public class AgencyTest {

    @Test
    public void testShouldCreateAgencyObjectAndGetNameShouldReturnConstructorAgencyName() {
        Agency test = new Agency("BulgariaAir", "Sofia", "Bulgaria",
                "+35987745215");
        assertEquals("BulgariaAir", test.getName());
    }

    @Test
    public void testShouldCreateAgencyObjectAndGetCityShouldReturnConstructorAgencyCity() {
        Agency test = new Agency("BulgariaAir", "Sofia", "Bulgaria",
                "+35987745215");
        assertEquals("Sofia", test.getCity());
    }

    @Test
    public void testShouldCreateAgencyObjectAndGetCountryShouldReturnConstructorAgencyCountry() {
        Agency test = new Agency("BulgariaAir", "Sofia", "Bulgaria",
                "+35987745215");
        assertEquals("Bulgaria", test.getCountry());
    }

    @Test
    public void testShouldCreateAgencyObjectAndGetPhoneNumberShouldReturnConstructorAgencyPhoneNumber() {
        Agency test = new Agency("BulgariaAir", "Sofia", "Bulgaria",
                "+35987745215");
        assertEquals("+35987745215", test.getPhoneNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailWhenSetNameIsInvokedWithIllegalArgument() {
        Agency test = new Agency("whatever", "Whatever", "Whatever",
                "+4578554568");
        test.setName("newWrongName");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailWhenSetCountryIsInvokedWithIllegalArgument() {
        Agency test = new Agency("ValidName", "whatever", "whatever",
                "+4578554568");
        test.setCountry("bulgaria");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailWhenSetCityIsInvokedWithIllegalArgument() {
        Agency test = new Agency("ValidName", "ValidCountry", "whatever",
                "+4578554568");
        test.setCity("wrong");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailWhenSetPhoneNumberIsInvokedWithIllegalArgument() {
        Agency test = new Agency("ValidName", "ValidCountry", "ValidName",
                "+4578554568");
        test.setPhoneNumber("0877458125");
    }
}
