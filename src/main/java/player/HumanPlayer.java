package player;

import lombok.Getter;
import util.NumberUtils;

@Getter
public class HumanPlayer extends Player {

    private final String name;

    public HumanPlayer() {
        System.out.print("Enter name for human player: ");
        this.name = getScanner().nextLine();
    }

    @Override
    public int getHeldNumber() {
        // No need to keep player's number
        return 0;
    }

    @Override
    public int guessNumber() {
        System.out.printf("%s, enter your guess: ", getName());
        while (true) {
            int guess = getScanner().nextInt();
            if (!NumberUtils.isValidNumber(guess)) {
                System.out.printf("%s, you entered invalid number.%n", getName());
                System.out.print("Try again: ");
                continue;
            }
            return guess;
        }
    }

    @Override
    public int[] checkNumber(int number) {
        System.out.printf("%s, enter cows and bulls: ", getName());
        int[] cowsAndBulls;
        while (true) {
            cowsAndBulls = new int[]{getScanner().nextInt(), getScanner().nextInt()};
            if (!NumberUtils.isValidCowsAndBulls(cowsAndBulls)) {
                System.out.printf("%s, you entered invalid cows and bulls.%n", getName());
                System.out.print("Try again: ");
                continue;
            }
            return cowsAndBulls;
        }
    }

    @Override
    public void handleNumberWithCowsAndBulls(int number, int[] cowsAndBulls) {
    }
}
