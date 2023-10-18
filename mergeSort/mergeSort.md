# Merge Sort
Merge sort is a “divide and conquer” algorithm wherein we first divide the array into smaller arrays. When the smaller arrays are of length 1, we compare and combine them together to get the final sorted solution to the array.

## Pseudocode
```
ALGORITHM Mergesort(arr)
    DECLARE n <-- arr.length

    if n > 1
      DECLARE mid <-- n/2
      DECLARE left <-- arr[0...mid]
      DECLARE right <-- arr[mid...n]
      // sort the left side
      Mergesort(left)
      // sort the right side
      Mergesort(right)
      // merge the sorted left and right sides together
      Merge(left, right, arr)

ALGORITHM Merge(left, right, arr)
    DECLARE i <-- 0
    DECLARE j <-- 0
    DECLARE k <-- 0

    while i < left.length && j < right.length
        if left[i] <= right[j]
            arr[k] <-- left[i]
            i <-- i + 1
        else
            arr[k] <-- right[j]
            j <-- j + 1

        k <-- k + 1

    if i = left.length
       set remaining entries in arr to remaining values in right
    else
       set remaining entries in arr to remaining values in left
```

## Code 

```java
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
```

## Trace

![MergeSort Tracing](./mergeSorting.PNG)

## Big o

1. Time: Time complexity of Merge Sort is  `O(nLogn)` in all 3 cases (worst, average and best) as merge sort always divides the array into two halves and takes linear time to merge two halves.
2. Space: `O(n)`