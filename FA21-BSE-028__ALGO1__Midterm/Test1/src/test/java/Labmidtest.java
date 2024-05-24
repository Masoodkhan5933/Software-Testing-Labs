import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Labmidtest {

    @Test
    public void oddlength() {
        ReverseArray reverseArray = new ReverseArray();
        int[] inputArray = {10, 20, 30, 40, 50};
        int[] expectedArray = {50, 40, 30, 20, 10};

        assertArrayEquals(expectedArray, reverseArray.reverseArray(inputArray));
    }

    @Test
    public void evenlength() {
        ReverseArray reverseArray = new ReverseArray();
        int[] inputArray = {24, 72, 93, 6};
        int[] expectedArray = {6, 93, 72, 24};

        assertArrayEquals(expectedArray, reverseArray.reverseArray(inputArray));
    }

    @Test
    public void testReverseArray_EmptyArray() {
        ReverseArray reverseArray = new ReverseArray();
        int[] inputArray = {};
        int[] expectedArray = {};

        assertArrayEquals(expectedArray, reverseArray.reverseArray(inputArray));
    }

    @Test
    public void testReverseArray_SingleElementArray() {
        ReverseArray reverseArray = new ReverseArray();
        int[] inputArray = {42};
        int[] expectedArray = {42};

        assertArrayEquals(expectedArray, reverseArray.reverseArray(inputArray));
    }

    @Test
    public void testReverseArray_NegativeNumbers() {
        ReverseArray reverseArray = new ReverseArray();
        int[] inputArray = {-17, -33, -1, -8};
        int[] expectedArray = {-8, -1, -33, -17};

        assertArrayEquals(expectedArray, reverseArray.reverseArray(inputArray));
    }
}
