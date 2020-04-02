package flight.system;

import java.util.Comparator;
import java.util.UUID;

public class Customer implements Comparable<Customer>, Cloneable {
    private String names;
    private String ID;
    private String phoneNumber;
    private String address;
    private CustomerType type;
    private String email;

    protected Customer(String names, String phoneNumber, String address,
            CustomerType customerType, String email) {
        validateNames(names);
        validatePhoneNumber(phoneNumber);
        this.ID = generateID();
        this.address = address;
        this.type = customerType;
        validateEmail(email);
    }

    private void validateNames(String names) {
        if (!names.matches("[A-Za-z ]+")) {
            names = " ";
            throw new IllegalArgumentException(
                    "Your names must conatain only letters and spaces between them");
        }
        this.names = names;
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^[+][\\d]+")) {
            phoneNumber = " ";
            throw new IllegalArgumentException("Phone format: {+digits}");
        }
        this.phoneNumber = phoneNumber;
    }

    private void validateEmail(String email) {
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            email = " ";
            throw new IllegalArgumentException("example@email.com");
        }
        this.email = email;
    }

    private String generateID() {
        return UUID.randomUUID().toString();
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        validateNames(names);
    }

    public String getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNum) {
        validatePhoneNumber(newPhoneNum);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public CustomerType getCustomerType() {
        return type;
    }

    public void setCustomerType(CustomerType customerType) {
        this.type = customerType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
    }

    @Override
    public String toString() {
        return "Customer [" + names + "," + ID + "," + phoneNumber + ","
                + address + "," + type + "," + email + "]";
    }

    @Override
    public int compareTo(Customer o) {
        return Comparator.comparing(Customer::getNames)
                .thenComparing(Customer::getAddress).compare(this, o);
    }

    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((names == null) ? 0 : names.hashCode());
        result = prime * result
                + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Customer other = (Customer) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (names == null) {
            if (other.names != null)
                return false;
        } else if (!names.equals(other.names))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

}
