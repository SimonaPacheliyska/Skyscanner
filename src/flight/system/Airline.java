package flight.system;

public class Airline implements Cloneable,Comparable<Airline> {
    private String name;
    private String country;

    public Airline(String name, String country) {
        validateName(name);
        validateCountry(country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        validateCountry(country);
    }

    public Airline clone() throws CloneNotSupportedException {
        return (Airline) super.clone();
    }

    private void validateName(String name) {
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException(
                    "Only alphabetics and spaces allowed");
        }
        this.name = name;
    }

    private void validateCountry(String country) {
        if (!country.matches("^[A-Z][a-zA-Z\\s]+")) {
            throw new IllegalArgumentException(
                    "Country must starts with uppercase and must contain only letters and spaces");
        }
        this.country = country;
    }

    @Override
    public String toString() {
        return "Airline:[" + name + "," + country + "]";
    }

    @Override
    public int compareTo(Airline o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Airline other = (Airline) obj;
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
        return true;
    }

}
