package flight.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Skyscanner s = new Skyscanner();
        Scanner scanner = new Scanner(System.in);
        s.search(scanner.nextLine());

    }

}
