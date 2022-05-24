import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) throws Exception {
        int[] numbers = { 6, 5, 8, 7, 11 };
        System.out.println("Smallest: " + smallest(numbers));
        System.out.println("Index of the smallest number: " + indexOfSmallest(numbers));

        int[] numbers2 = { -1, 6, 9, 8, 12 };
        System.out.println(indexOfSmallestFrom(numbers2, 0));
        System.out.println(indexOfSmallestFrom(numbers2, 1));
        System.out.println(indexOfSmallestFrom(numbers2, 2));

        int[] numbers3 = { 3, 2, 5, 4, 8 };
        System.out.println(Arrays.toString(numbers3));
        swap(numbers3, 1, 0);
        System.out.println(Arrays.toString(numbers3));
        swap(numbers3, 0, 3);
        System.out.println(Arrays.toString(numbers3));

        int[] numbers4 = {8, 3, 7, 9, 1, 2, 4};
        sort(numbers4);
    }

    public static int smallest(int[] array) {
        int num = array[0];
        for (int x : array) {
            if (x < num) {
                num = x;
            }
        }
        return num;
    }

    public static int indexOfSmallest(int[] array) {
        int small = smallest(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == small) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfSmallestFrom(int[] array, int startIndex) {
        int num = array[startIndex];
        int index = startIndex;
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < num) {
                num = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array));
            int small = indexOfSmallestFrom(array, i);
            swap(array, i, small);
        }
    }
}
