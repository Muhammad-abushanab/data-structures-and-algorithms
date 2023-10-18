package mergeSort;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int length = arr.length;
        if (length > 1) {
            int mid = length / 2;
            int[] left = new int[mid];
            int[] right = new int[length - mid];
            System.arraycopy(arr, 0, left, 0, mid);
            if (length - mid >= 0) System.arraycopy(arr, mid, right, 0, length - mid);
            mergeSort(left);
            mergeSort(right);
            merge(left, right, arr);
        }
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
