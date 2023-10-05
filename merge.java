public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the left and right halves of the array.
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves of the array.
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Create two temporary arrays to store the left and right halves of the array.
        int[] leftTemp = new int[mid - left + 1];
        int[] rightTemp = new int[right - mid];

        // Copy the left and right halves of the array to the temporary arrays.
        for (int i = 0; i < mid - left + 1; i++) {
            leftTemp[i] = arr[left + i];
        }
        for (int i = 0; i < right - mid; i++) {
            rightTemp[i] = arr[mid + 1 + i];
        }

        // Merge the two temporary arrays back into the original array.
        int i = 0, j = 0, k = left;
        while (i < leftTemp.length && j < rightTemp.length) {
            if (leftTemp[i] <= rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            } else {
                arr[k] = rightTemp[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the temporary arrays to the original array.
        while (i < leftTemp.length) {
            arr[k] = leftTemp[i];
            i++;
            k++;
        }
        while (j < rightTemp.length) {
            arr[k] = rightTemp[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};

        // Merge sort the array.
        mergeSort(arr);

        // Print the sorted array.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
