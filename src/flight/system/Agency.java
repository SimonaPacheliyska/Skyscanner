package flight.system;

public class Agency implements Cloneable, Comparable<Agency> {

    private String name;
    private String city;
    private String country;
    private String phoneNumber;

    public Agency(String name, String city, String country,
            String phoneNumber) {
        validateName(name);
        validateCity(city);
        validateCountry(country);
        validatePhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        validateCity(city);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        validateCountry(country);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^[+][\\d]+")) {
            phoneNumber = " ";
            throw new IllegalArgumentException("Phone format: {+digits}");
        }
        this.phoneNumber = phoneNumber;
    }

    private void validateCountry(String country) {
        boolean isValid = country.matches("^[A-Z][a-zA-Z\\s]+")
                || country.matches("^[A-Z][a-zA-Z]+");
        if (!isValid) {
            throw new IllegalArgumentException(
                    "Country must contain only alphabetics and must start with uppercase");
        }
        this.country = country;
    }

    private void validateCity(String city) {
        boolean isValid = city.matches("[^[A-Z][a-zA-Z\\s]]+")
                || city.matches("[^[A-Z][a-zA-Z]]+");
        if (!isValid) {
            throw new IllegalArgumentException(
                    "Only alphabetics and spaces allowed");
        }
        this.city = city;
    }

    private void validateName(String name) {
        if (!name.matches("^[A-Z][A-Za-z\\d\\s]+")) {
            throw new IllegalArgumentException(
                    "Name can contain letters, digits and spaces");
        }
        this.name = name;
    }

    @Override
    public int compareTo(Agency o) {
        return this.name.compareTo(o.name);
    }

    public Agency clone() throws CloneNotSupportedException {
        return (Agency) super.clone();
    }

    @Override
    public String toString() {
        return "Agency:[" + name + "," + city + "," + country + ","
                + phoneNumber + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
        Agency other = (Agency) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
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
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        return true;
    }

}
