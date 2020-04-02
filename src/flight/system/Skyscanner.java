package flight.system;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Skyscanner {
    private ReservationHandler resHandler;
    private SearchHandler sHandler;
    private CommandParser parser;
    private String[] userInput;

    public Skyscanner() throws CloneNotSupportedException {
        this.resHandler = new ReservationHandler();
        this.sHandler = new SearchHandler();
        this.parser = new CommandParser();
        System.out
                .println("From:\n    [" + getRegisteredDeptAirports() + "]");
        System.out.println("To:\n    [" + getRegisteredArrvAirports() + "]\n");
        printSearchPattern();
    }

    public String getRegisteredDeptAirports() {
        StringBuilder sBuilder = new StringBuilder();
        Set<String> contries = sHandler.getFlights().stream()
                .map(flight -> flight.getDeptAirport().getCountry())
                .collect(Collectors.toSet());
        contries.forEach(country -> sBuilder.append(country + ", "));
        return sBuilder.toString();
    }

    public String getRegisteredArrvAirports() {
        StringBuilder builder = new StringBuilder();
        Set<String> contries = sHandler.getFlights().stream()
                .map(flight -> flight.getArrvAirport().getCountry())
                .collect(Collectors.toSet());
        contries.forEach(country -> builder.append(country + ", "));
        return builder.toString();
    }

    public void search(String line) {
        userInput = parser.parseCommand(line);
        if (!sHandler.containsFromCountry(userInput[0])
                || !sHandler.containsToCountry(userInput[1])) {
            System.out.println("Invalid input. Try again");
            userInput = parser.parseCommand(line);
        }
        
    }

    public static void printSearchPattern() {
        System.out.print("Pattern: ");
        System.out.println("{From To Depart Return CabinClass&Travellers}");
        System.out.println(
                "Example: Sofia Moscow 10/09/2018 17/09/2018 1 adult,Economy");
        System.out.println("Search:");
    }

}
