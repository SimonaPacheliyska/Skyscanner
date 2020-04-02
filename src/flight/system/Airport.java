package flight.system;

import java.util.Comparator;

public class Airport implements Cloneable, Comparable<Airport> {
    private final byte CODE_LENGTH = 3;

    private String name;
    private String code;
    private String town;
    private String country;
    private byte GMT;

    public Airport(String name, String code, String town, String country,
            byte GMT) {
        validateName(name);
        validateCode(code);
        validateTown(town);
        vaidateCountry(country);
        validateGMT(GMT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        validateCode(code);
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        validateTown(town);
    }

    public String getCountry() {
        return country;

    }

    public void setCountry(String country) {
        vaidateCountry(country);
    }

    public byte GMT() {
        return GMT;
    }

    public void setGMT(byte GMT) {
        validateGMT(GMT);
    }

    private void validateName(String name) {
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException(
                    "Only alphabetics and spaces allowed");
        }
        this.name = name;
    }

    private void validateCode(String code) {
        if (code.length() != CODE_LENGTH || !code.matches("[A-Z]+")) {
            throw new IllegalArgumentException(
                    "Only 3 uppercase letters allowed");
        }
        this.code = code;
    }

    private void validateTown(String town) {
        boolean isValid = town.matches("[^[A-Z][a-zA-Z\\s]+]")
                || town.matches("[^[A-Z][a-zA-Z]+]");
        if (isValid) {
            throw new IllegalArgumentException(
                    "Only alphabetics and spaces allowed");
        }
        this.town = town;
    }

    private void vaidateCountry(String country) {
        if (!country.matches("^[A-Z][a-zA-Z\\\\s]+")) {
            throw new IllegalArgumentException(
                    "Country must contain only alphabetics and must start with uppercase");
        }
        this.country = country;
    }

    private void validateGMT(byte GMT) {
        boolean isDigit = Math.abs(GMT) >= 0 && Math.abs(GMT) <= 9;
        if (!isDigit) {
            throw new IllegalArgumentException(
                    "GMT might be a digit (example: {-2,0,2} )");
        }
        this.GMT = GMT;
    }

    @Override
    public int compareTo(Airport o) {
        return Comparator.comparing(Airport::getCode).compare(this, o);
    }

    public Airport clone() throws CloneNotSupportedException {
        return (Airport) super.clone();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + CODE_LENGTH;
        result = prime * result + GMT;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((town == null) ? 0 : town.hashCode());
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
        Airport other = (Airport) obj;
        if (CODE_LENGTH != other.CODE_LENGTH)
            return false;
        if (GMT != other.GMT)
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (town == null) {
            if (other.town != null)
                return false;
        } else if (!town.equals(other.town))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Airport [" + name + "," + code + "," + town + "," + country
                + "," + GMT + "]";
    }

}
