package player;

import java.util.Scanner;

public abstract class Player {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Scanner getScanner() {
        return SCANNER;
    }

    public abstract String getName();

    public abstract int getHeldNumber();

    public abstract int guessNumber();

    public abstract int[] checkNumber(int number);

    public abstract void handleNumberWithCowsAndBulls(int number, int[] cowsAndBulls);
}
