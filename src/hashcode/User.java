package hashcode;

import java.util.Scanner;

public class User {
    private static final Scanner read = new Scanner(System.in);
    private static String input;

    public static void promptInput() {
        input = read.nextLine();
    }

    public static String getInput() {
        return input;
    }
}