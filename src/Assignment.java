import java.util.Arrays;

public class Assignment {
    public static void main(String[] args) {
        int[] array = { 34, 76, 2, 5, 90, 102 };
        System.out.println("Original array: " + Arrays.toString(array));
        bubblesort(array);
        System.out.println("Bubble sorted array: " + Arrays.toString(array));

        String sortme = "lnargoyaweglrgj";
        System.out.println(countSort(sortme));

        int[] array2 = { 34, 67, 5, 908, 123, 34, 676, 42 };
        System.out.println("Original array: " + Arrays.toString(array2));
        quickSort(array2);
        System.out.println("Quicksorted array: " + Arrays.toString(array2));
    }

    // having the array length be a parameter seemed unnecessary, 
    // and leaves more room for user error
    public static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static String countSort(String arr) {
        char[] letters = arr.toCharArray();
        char[] sorted = new char[arr.length()];

        int[] count = new int[256];

        for (int i = 0; i < letters.length; i++) {
            count[letters[i]]++;
        }

        int i = 0;
        for (char j = 0; j < count.length; j++) {
            for (int k = 0; k < count[j]; k++) {
                sorted[i] = j;
                i++;
            }
        }

        return new String(sorted);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (high - low < 2) {
            return;
        }
        int mid = partition(arr, low, high);
        quickSort(arr, low, mid);
        quickSort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        for (int i = low; i < high; i++) {
            if (arr[i] > pivot) {
                int val = arr[i];
                for (int j = i; j < high - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[high - 1] = val;
            } else if (arr[i] < pivot) {
                int val = arr[i];
                for (int k = i; k > low; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[low] = val;
            }
        }

        for (int i = low; i < high; i++) {
            if (arr[i] == pivot) {
                return i;
            }
        }
        return -1;
    }
}
