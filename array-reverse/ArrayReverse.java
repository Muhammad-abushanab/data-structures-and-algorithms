public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
        int[] arr2 = {};
        int[] arr3 = {51,2};
        printArray(reverse(arr3));
        System.out.println("End of arr3");
        printArray(reverse(arr1));
        System.out.println("End of arr1");
        printArray(reverse(arr2));
    }
    
    public static int[] reverse(int[] arr) {
        int count = 0;
        int[] reverse = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse[count] = arr[i];
            count++;
        }
        return reverse;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}