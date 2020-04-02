package flight.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ReservationHandler implements ReservationManager {
    private Map<Customer, Set<Ticket>> reservations;

    public ReservationHandler() {
        reservations = new HashMap<>();
    }

    @Override
    public void registerCustomer(Customer customer) {
        reservations.put(customer, new TreeSet<>());
    }

    @Override
    public Set<Customer> getAllRegisteredCustomers() {
        List<Customer> toReturn = new ArrayList<>();
        return new TreeSet<>(toReturn);
    }

    @Override
    public void bookTicket(Customer customer, Ticket ticket) {
        if (!reservations.containsKey(customer)) {
            registerCustomer(customer);
        }
        reservations.get(customer).add(ticket);
    }

    @Override
    public Set<Ticket> getCustomerTickets(Customer customer) {
        return reservations.get(customer);
    }

}
