package flight.system;

import java.util.Comparator;

public class Airplane implements Cloneable, Comparable<Airplane> {
    private final byte CODE_LENGTH = 4;

    private String name;
    private String code;
    private int fclass_seats_capacity;
    private int sclass_seats_capacity;

    public Airplane(String name, String code, int fclass_seats_capacity,
            int sclass_seats_capacity) {
        validateName(name);
        validateCode(code);
        validateFClassSeats(fclass_seats_capacity);
        validateSClassSeats(sclass_seats_capacity);
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

    public int getFClassSeats() {
        return fclass_seats_capacity;
    }

    public void setFClassSeats(int capacity) {
        validateFClassSeats(capacity);
    }

    public int getSClassSeats() {
        return sclass_seats_capacity;
    }

    public void setSClassSeats(int sclass_seats_capacity) {
        validateSClassSeats(sclass_seats_capacity);
    }

    private void validateName(String name) {
        if (!name.matches("[a-zA-Z\\s\\d]+")) {
            this.name = " ";
            throw new IllegalArgumentException(
                    "Only alphabetics, digts and spaces allowed");
        }
        this.name = name;
    }

    private void validateCode(String code) {
        boolean isValidCode = code.length() == CODE_LENGTH
                && code.matches("[\\w\\d]+");
        if (!isValidCode) {
            throw new IllegalArgumentException(
                    "Code must contain 4 characters (digits allowed)");
        }
        this.code = code;
    }

    private void validateSClassSeats(int sclass_seats_capacity) {
        if (sclass_seats_capacity < 0) {
            throw new IllegalArgumentException(
                    "Capacity might be a positive number");
        }
        this.sclass_seats_capacity = sclass_seats_capacity;
    }

    private void validateFClassSeats(int fclass_seats_capacity) {
        if (fclass_seats_capacity < 0) {
            throw new IllegalArgumentException(
                    "Capacity might be a positive number");
        }
        this.fclass_seats_capacity = fclass_seats_capacity;
    }

    @Override
    public int compareTo(Airplane o) {
        return Comparator.comparing(Airplane::getName)
                .thenComparing(Airplane::getCode).compare(this, o);
    }

    public Airplane clone() throws CloneNotSupportedException {
        return (Airplane) super.clone();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + CODE_LENGTH;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + fclass_seats_capacity;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + sclass_seats_capacity;
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
        Airplane other = (Airplane) obj;
        if (CODE_LENGTH != other.CODE_LENGTH)
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (fclass_seats_capacity != other.fclass_seats_capacity)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (sclass_seats_capacity != other.sclass_seats_capacity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Airplane:[" + name + "," + code + ", fclass:"
                + fclass_seats_capacity + ",sclass:" + sclass_seats_capacity
                + "]";
    }

}
