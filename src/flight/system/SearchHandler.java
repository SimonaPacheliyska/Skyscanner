package flight.system;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchHandler {
    private Map<Flight, Set<Ticket>> flightTickets;

    public SearchHandler() throws CloneNotSupportedException {
        this.flightTickets = new TreeMap<>();
        fillInFlights();
    }

    private void fillInFlights() throws CloneNotSupportedException {
        Flight a = new Flight(new Airline("WizzAir", "UK"),
                new Airplane("Boeing147", "ABx5", 75, 55),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("Fiumicino", "FCO", "Rome", "Italy", (byte) 2),
                LocalTime.of(9, 10), LocalTime.of(12, 45), 200);
        Flight b = new Flight(new Airline("Aeroflot", "Russia"),
                new Airplane("Boeing17", "AMx4", 120, 65),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("Sheremetievo", "SHE", "Moscow", "Russia",
                        (byte) 2),
                LocalTime.of(13, 05), LocalTime.of(13, 45), 150);
        Flight c = new Flight(new Airline("SrbijaLine", "Srbija"),
                new Airplane("Boeing137", "A4x4", 50, 30),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("AirSrbija", "SRB", "Belgrade", "Srbija", (byte) 2),
                LocalTime.of(8, 20), LocalTime.of(10, 45), 50);
        Flight d = new Flight(new Airline("BulgariaAir", "Bulgaria"),
                new Airplane("Boeing174", "B4x4", 80, 60),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("Tegel", "TXL", "Berlin", "Germany", (byte) 1),
                LocalTime.of(7, 50), LocalTime.of(10, 45), 160);
        Flight e = new Flight(new Airline("Adria", "Austria"),
                new Airplane("Boeing14", "A9x4", 80, 60),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("Wien", "VIE", "Wien", "Ausria", (byte) 1),
                LocalTime.of(6, 10), LocalTime.of(8, 20), 140);
        Flight f = new Flight(new Airline("AirFrance", "France"),
                new Airplane("Boeing18", "F9x4", 70, 40),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("Charl de Gol", "CDG", "Paris", "France", (byte) 1),
                LocalTime.of(5, 45), LocalTime.of(8, 45), 80);
        Flight g = new Flight(new Airline("Lufthansa", "Germany"),
                new Airplane("Boeing12", "F9x4", 50, 30),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("Frederic Chopin", "FCH", "Warszawa", "Poland",
                        (byte) 1),
                LocalTime.of(6, 02), LocalTime.of(8, 15), 70);
        Flight h = new Flight(new Airline("EasyJet", "UK"),
                new Airplane("Boeing112", "M9x4", 50, 30),
                new Airport("SofiaAirport", "SOF", "Sofia", "Bulgaria",
                        (byte) 2),
                new Airport("Heathrow", "LTN", "London", "UK", (byte) 1),
                LocalTime.of(5, 20), LocalTime.of(8, 45), 70);
        this.flightTickets.put(a, new TreeSet<>());
        this.flightTickets.put(b, new TreeSet<>());
        this.flightTickets.put(c, new TreeSet<>());
        this.flightTickets.put(d, new TreeSet<>());
        this.flightTickets.put(e, new TreeSet<>());
        this.flightTickets.put(f, new TreeSet<>());
        this.flightTickets.put(g, new TreeSet<>());
        this.flightTickets.put(h, new TreeSet<>());
    }

    public Map<Flight, Set<Ticket>> getFlightTickets() {
        return flightTickets;
    }

    public Set<Flight> getFlights() {
        return this.flightTickets.keySet();
    }

    public void listChosenFlights(String from, String to) {
        Set<Flight> filteredFlights = getFlights().stream().filter(flight -> flight.getDeptAirport().getCountry().equals(from)).
        filter(flight -> flight.getArrvAirport().getCountry().equals(to)).collect(Collectors.toSet());
        filteredFlights.forEach(flight -> System.out.println(flight));
    }

    public boolean containsFromCountry(String country) {
        return getDeptCountries().contains(country);
    }

    public boolean containsToCountry(String country) {
        return getArrvCountries().contains(country);
    }

    private Set<String> getDeptCountries() {
        Set<String> deptCountries = new TreeSet<>();
        this.flightTickets.keySet().forEach(flight -> deptCountries
                .add(flight.getDeptAirport().getCountry()));
        return deptCountries;
    }

    private Set<String> getArrvCountries() {
        Set<String> arrvCountries = new TreeSet<>();
        this.flightTickets.keySet().forEach(flight -> arrvCountries
                .add(flight.getArrvAirport().getCountry()));
        return arrvCountries;
    }

}
