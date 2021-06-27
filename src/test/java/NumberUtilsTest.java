import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import util.NumberUtils;

public class NumberUtilsTest {

    private static final int[] VALID_NUMBERS = {
        1234, 5678, 1290, 5690
    };

    private static final int[] INVALID_NUMBERS = {
        1212, 1201, 5605, 4477
    };

    @Test
    public void testCheckNumbers() {
        assertArrayEquals(NumberUtils.checkNumbers(1234, 5678), new int[]{0, 0});
        assertArrayEquals(NumberUtils.checkNumbers(1234, 1234), new int[]{4, 4});
        assertArrayEquals(NumberUtils.checkNumbers(1234, 1678), new int[]{1, 1});
        assertArrayEquals(NumberUtils.checkNumbers(1230, 1058), new int[]{2, 1});
        assertArrayEquals(NumberUtils.checkNumbers(1982, 1934), new int[]{2, 2});
        assertArrayEquals(NumberUtils.checkNumbers(9407, 7261), new int[]{1, 0});
    }

    @Test
    public void testIsNumberValid() {
        for (int i : VALID_NUMBERS) {
            assertTrue(NumberUtils.isValidNumber(i));
        }
        for (int i : INVALID_NUMBERS) {
            assertFalse(NumberUtils.isValidNumber(i));
        }
    }
}
