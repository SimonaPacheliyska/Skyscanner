package flight.system;

import java.util.Set;

public interface ReservationManager {

    void registerCustomer(Customer customer);

    Set<Customer> getAllRegisteredCustomers();

    void bookTicket(Customer customer, Ticket ticket);

    Set<Ticket> getCustomerTickets(Customer customer);

}
