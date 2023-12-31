/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package insertionSort;

public class App {

    public static void main(String[] args) throws Exception {
        int[] arr = {8, 4, 23, 42, 16, 15};
        int[] reversedSorted = {20, 18, 12, 8, 5, -2};
        int[] fewUniques = {5, 12, 7, 5, 5, 7};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        insertionSort.sort(reversedSorted);
        insertionSort.sort(fewUniques);
        for (int num : arr) {
            System.out.println(num);
        }
        System.out.println("End of 1st Array");
        for (int num : reversedSorted
        ) {
            System.out.println(num);
        }
        System.out.println("End of 2nd Array");
        for (int num :
                fewUniques) {
            System.out.println(num);
        }
        System.out.println("End of 3rd Array");
    }
}
