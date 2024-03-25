public class QuickSort {

    void swap(int a[], int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }

    int partition(int a[], int start, int end) {
        int pivot = a[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (a[i] <= pivot && i < end) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(a, i, j);
            }
        }

        // Swap the pivot element with the element at index j
        swap(a, start, j);

        return j;
    }

    void quickSort(int a[], int start, int end) {
        if (start < end) {
            int pivot = partition(a, start, end);
            quickSort(a, start, pivot - 1);
            quickSort(a, pivot + 1, end);
        }
    }
}
