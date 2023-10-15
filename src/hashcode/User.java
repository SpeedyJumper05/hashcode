package hashcode;

import java.util.Scanner;

public class User {
    private final Scanner read = new Scanner(System.in);
    private String input;

    public void promptInput() {
        input = read.nextLine();
    }

    public String getInput() {
        return input;
    }
}