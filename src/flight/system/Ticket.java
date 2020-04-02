package flight.system;

public class Ticket implements Comparable<Ticket> {
    private final byte CODE_LENGTH = 10;

    private String code;
    private String agency;
    private String airOperator;
    private String flightInfo;
    private Customer passenger;
    private String fromAirport;
    private String toAirport;
    private String seat;
    private CabinClass cabinClass;
    private double price;

    public Ticket(String code, Agency agency, Airline operator,
            Flight flightInfo, Customer passenger, Airport from, Airport to,
            String seat, CabinClass cabinClass, double price)
            throws CloneNotSupportedException {
        validateCode(code);
        this.agency = agency.getName();
        this.setAirOperator(operator);
        this.flightInfo = flightInfo.getCode();
        this.passenger = passenger.clone();
        this.setFromAirport(from);
        this.setToAirport(to);
        vaidateSeat(seat);
        this.setCabinClass(cabinClass);
        validatePrice(price);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency.getName();
    }

    public String getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(Flight flightInfo) {
        this.flightInfo = flightInfo.getCode();
    }

    public Customer getPassenger() {
        return passenger;
    }

    public void setPassenger(Customer passenger) {
        this.passenger = passenger;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        vaidateSeat(seat);
    }

    public String getAirOperator() {
        return airOperator;
    }

    public void setAirOperator(Airline airOperator) {
        this.airOperator = airOperator.getName();
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport from) {
        this.fromAirport = new String(from.getName() + "/" + from.getCountry());
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport to) {
        this.toAirport = new String(to.getName() + "/" + to.getCountry());
    }

    public double getPrice() {
        return price;
    }

    public CabinClass getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(CabinClass cabinClass) {
        this.cabinClass = cabinClass;
    }

    private void validateCode(String code) {
        boolean isValidCode = code.length() == CODE_LENGTH
                && code.matches("[0-9]+");
        if (!isValidCode) {
            throw new IllegalArgumentException("10 digits allowed");
        }
        this.code = code;
    }

    private void vaidateSeat(String seat) {
        if (!seat.matches("[\\w\\d]+")) {
            throw new IllegalArgumentException("Digits and alphabetics only");
        }
        this.seat = seat;
    }

    private void validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be positive number");
        }
        this.price = price;
    }

    @Override
    public int compareTo(Ticket o) {
        return new Double(this.price).compareTo(new Double(o.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + CODE_LENGTH;
        result = prime * result + ((agency == null) ? 0 : agency.hashCode());
        result = prime * result
                + ((airOperator == null) ? 0 : airOperator.hashCode());
        result = prime * result
                + ((cabinClass == null) ? 0 : cabinClass.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result
                + ((flightInfo == null) ? 0 : flightInfo.hashCode());
        result = prime * result
                + ((fromAirport == null) ? 0 : fromAirport.hashCode());
        result = prime * result
                + ((passenger == null) ? 0 : passenger.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((seat == null) ? 0 : seat.hashCode());
        result = prime * result
                + ((toAirport == null) ? 0 : toAirport.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ticket other = (Ticket) obj;
        if (CODE_LENGTH != other.CODE_LENGTH)
            return false;
        if (agency == null) {
            if (other.agency != null)
                return false;
        } else if (!agency.equals(other.agency))
            return false;
        if (airOperator == null) {
            if (other.airOperator != null)
                return false;
        } else if (!airOperator.equals(other.airOperator))
            return false;
        if (cabinClass != other.cabinClass)
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (flightInfo == null) {
            if (other.flightInfo != null)
                return false;
        } else if (!flightInfo.equals(other.flightInfo))
            return false;
        if (fromAirport == null) {
            if (other.fromAirport != null)
                return false;
        } else if (!fromAirport.equals(other.fromAirport))
            return false;
        if (passenger == null) {
            if (other.passenger != null)
                return false;
        } else if (!passenger.equals(other.passenger))
            return false;
        if (Double.doubleToLongBits(price) != Double
                .doubleToLongBits(other.price))
            return false;
        if (seat == null) {
            if (other.seat != null)
                return false;
        } else if (!seat.equals(other.seat))
            return false;
        if (toAirport == null) {
            if (other.toAirport != null)
                return false;
        } else if (!toAirport.equals(other.toAirport))
            return false;
        return true;
    }
    
}
