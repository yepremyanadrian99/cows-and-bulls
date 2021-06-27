package player;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import lombok.Getter;
import util.NumberUtils;

@Getter
public class RobotPlayer extends Player {

    private static final int DEFAULT_NULL_VALUE = 0;

    private final String name;
    private final int heldNumber;

    private final Set<Integer> combinations;

    public RobotPlayer() {
        System.out.print("Enter name for robot player: ");
        name = getScanner().next();
        combinations = NumberUtils.generateCombinations();
        heldNumber = NumberUtils.randomNumberFromCombinations(combinations);
    }

    public void removePerNumberAndCowsAndBulls(int number, int[] cowsAndBulls) {
        combinations.removeIf(combinationNumber -> !Arrays.equals(NumberUtils.checkNumbers(combinationNumber, number), cowsAndBulls));
    }

    public int guessNumber() {
        System.out.printf("%s, enter your guess: ", getName());
        Set<Integer> combinations = getCombinations();
        Iterator<Integer> it = combinations.iterator();
        if (it.hasNext()) {
            int guessedNumber = it.next();
            System.out.println(guessedNumber);
            return guessedNumber;
        }
        return DEFAULT_NULL_VALUE;
    }

    public int[] checkNumber(int number) {
        System.out.printf("%s, enter cows and bulls: ", getName());
        int[] cowsAndBulls = NumberUtils.checkNumbers(number, getHeldNumber());
        System.out.printf("%d:%d%n", cowsAndBulls[0], cowsAndBulls[1]);
        return cowsAndBulls;
    }

    public void handleNumberWithCowsAndBulls(int number, int[] cowsAndBulls) {
        removePerNumberAndCowsAndBulls(number, cowsAndBulls);
    }
}
