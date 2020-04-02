package flight.system;

import java.util.Comparator;

public class PriceComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return Double.valueOf(o1.getPrice())
                .compareTo(Double.valueOf(o2.getPrice()));
    }
}
