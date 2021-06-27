package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

public class NumberUtils {

    public static final Integer MIN_VALUE = 1023;
    public static final Integer MAX_VALUE = 9876;

    private NumberUtils() {
    }

    public static int randomNumberFromCombinations(Set<Integer> combinations) {
        int maxIndex = combinations.size();
        int index = new Random().nextInt(maxIndex);
        Iterator<Integer> it = combinations.iterator();
        for (int i = 0; i <= index; ++i) {
            it.next();
        }
        return it.next();
    }

    public static Set<Integer> generateCombinations() {
        Set<Integer> combinations = new HashSet<>();
        for (int i = MIN_VALUE; i <= MAX_VALUE; ++i) {
            if (NumberUtils.isValidNumber(i)) {
                combinations.add(i);
            }
        }
        return combinations;
    }

    public static int[] checkNumbers(int n1, int n2) {
        if (!(isValidNumber(n1) && isValidNumber(n2))) {
            return new int[]{0, 0};
        }
        int[] digits1 = getDigits(n1);
        int[] digits2 = getDigits(n2);
        int cows = getCows(digits1, digits2);
        int bulls = getBulls(digits1, digits2);
        return new int[]{cows, bulls};
    }

    public static boolean isValidNumber(int n) {
        return n >= MIN_VALUE && n <= MAX_VALUE && !isNumberWithRepeatingDigits(n);
    }

    public static boolean isValidCowsAndBulls(int[] cowsAndBulls) {
        if (cowsAndBulls.length != 2) {
            return false;
        }
        int cows = cowsAndBulls[0];
        int bulls = cowsAndBulls[1];
        return cows <= 4 && bulls <= 4 && bulls <= cows;
    }

    private static boolean isNumberWithRepeatingDigits(int n) {
        int[] bucket = new int[10];
        int[] digits = getDigits(n);
        for (int i : digits) {
            ++bucket[i];
        }
        for (int i : bucket) {
            if (i > 1) {
                return true;
            }
        }
        return false;
    }

    private static int[] getDigits(int n) {
        int[] digits = new int[4];
        int t = 1000;
        for (int i = 0; i < 4; ++i) {
            int d = n / t % 10;
            digits[i] = d;
            t /= 10;
        }
        return digits;
    }

    private static int getCows(int[] digits1, int[] digits2) {
        return CollectionUtils.intersection(
            Arrays.stream(digits1).boxed().collect(Collectors.toList()),
            Arrays.stream(digits2).boxed().collect(Collectors.toList())
        ).size();
    }

    private static int getBulls(int[] digits1, int[] digits2) {
        int count = 0;
        for (int i = 0; i < digits1.length && i < digits2.length; ++i) {
            if (digits1[i] == digits2[i]) {
                ++count;
            }
        }
        return count;
    }
}
