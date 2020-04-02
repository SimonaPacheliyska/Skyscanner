package flight.system;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandParser {
    private Scanner reader;

    public CommandParser() {
        reader = new Scanner(System.in);
    }

    public String[] parseCommand(String line) {
        while (!isValidSearch(line)) {
            System.out.println("Invalid input. Please try again");
            Skyscanner.printSearchPattern();
            String input = reader.nextLine();
        }
        String[] splitted = line.split("[\\s]");
        return splitted;
    }

    private boolean isValidSearch(String line) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+[\\s[a-zA-Z]\\d/,]+[a-zA-Z]+$");
        return pattern.matcher(line).matches();
    }
}
