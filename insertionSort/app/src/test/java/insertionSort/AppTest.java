/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package insertionSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void givenRandomArray_SortUsingInsertionSort() throws Exception {
        int[] arr = {8, 4, 23, 42, 16, 15};
        InsertionSort ins = new InsertionSort();
        ins.sort(arr);
        int[] expected = {4,8,15,16,23,42};
        Assertions.assertArrayEquals(expected,arr);
    }
}
