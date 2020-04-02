package flight.system;

import java.time.LocalTime;
import java.util.UUID;

public class Flight implements Comparable<Flight> {

    private String code;
    private Airline operator;
    private Airplane airplane;
    private Airport deptAirport;
    private Airport arrvAirport;
    private LocalTime deptTime;
    private LocalTime arrvTime;
    private LocalTime flightTime;
    private int flightKm;

    public Flight(Airline operator, Airplane airplane, Airport deptAirport,
            Airport arrvAirport, LocalTime deptTime, LocalTime arrvTime,
            int flightKm) throws CloneNotSupportedException {
        this.code = UUID.randomUUID().toString();
        this.setOperator(operator.clone());
        this.setAirplane(airplane.clone());
        this.setDeptAirport(deptAirport.clone());
        this.setArrvAirport(arrvAirport.clone());
        validateTimes(deptTime, arrvTime);
        validateFlightKm(flightKm);
    }

    private void validateFlightKm(int flightKm) {
        if (flightKm < 1) {
            throw new IllegalArgumentException(
                    "Kilometers must be non-zero integer");
        }
        this.flightKm = flightKm;
    }

    private void validateTimes(LocalTime deptTime, LocalTime arrvTime) {
        if (deptTime.compareTo(arrvTime) == -1) {
            this.deptTime = deptTime;
            this.arrvTime = arrvTime;
            return;
        }
        throw new IllegalArgumentException(
                "Departure time must be earlier than arrive time");
    }

    public String getCode() {
        return code;
    }

    public Airline getOperator() {
        return new Airline(this.operator.getName(), this.operator.getCountry());
    }

    public void setOperator(Airline operator) {
        this.operator = new Airline(operator.getName(), operator.getCountry());
    }

    public Airplane getAirplane() {
        return new Airplane(airplane.getName(), airplane.getCode(),
                airplane.getFClassSeats(), airplane.getSClassSeats());
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = new Airplane(airplane.getName(), airplane.getCode(),
                airplane.getFClassSeats(), airplane.getSClassSeats());
    }

    public Airport getDeptAirport() {
        return new Airport(deptAirport.getName(), deptAirport.getCode(),
                deptAirport.getTown(), deptAirport.getCountry(),
                deptAirport.GMT());
    }

    public void setDeptAirport(Airport deptAirport) {
        this.deptAirport = new Airport(deptAirport.getName(),
                deptAirport.getCode(), deptAirport.getTown(),
                deptAirport.getTown(), deptAirport.GMT());
    }

    public Airport getArrvAirport() {
        return new Airport(arrvAirport.getName(), arrvAirport.getCode(),
                arrvAirport.getTown(), arrvAirport.getCountry(),
                arrvAirport.GMT());
    }

    public void setArrvAirport(Airport arrvAirport) {
        this.arrvAirport = new Airport(arrvAirport.getName(),
                arrvAirport.getCode(), arrvAirport.getTown(),
                arrvAirport.getCountry(), arrvAirport.GMT());
    }

    public LocalTime getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(LocalTime deptTime) {
        this.deptTime = deptTime;
    }

    public LocalTime getArrvTime() {
        return arrvTime;
    }

    public void setArrvTime(LocalTime arrvTime) {
        this.arrvTime = arrvTime;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public int getFlightKm() {
        return flightKm;
    }

    public void setFlightKm(int flightKm) {
        this.flightKm = flightKm;
    }

    @Override
    public int compareTo(Flight o) {
        return this.code.compareTo(o.code);
    }
}
