public class Main {

    public static void main(String[] args) {
        int[] array1 = new int[] {10, 5, 1, 8, 3, 6, 2, 4, 9, 7};
        System.out.println("Пример 1. \n" + arrayToString(array1));
        mergeSort(array1);

        int[] array2 = new int[] {20, 10, 16, 6, 2, 14, 8, 4, 18, 12};
        System.out.println("Пример 2. \n" + arrayToString(array2));
        mergeSort(array2);

        int[] array3 = new int[] {11, 37, 19, 2, 19, 65, 44};
        System.out.println("Пример 3. \n" + arrayToString(array3));
        mergeSort(array3);

        int[] array4 = new int[] {99, 31, 85, 24, 32, 11, 56, 20, 91, 44, 77, 13, 36};
        System.out.println("Пример 4. \n" + arrayToString(array4));
        mergeSort(array4);
    }

    public static void mergeSort(int[] array) {
        int[] arrSrc = array;
        int[] arrDest = new int[array.length];
        int[] tmp;

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(arrSrc, i, arrSrc, i + size, arrDest, i, size);
            }

            tmp = arrSrc;
            arrSrc = arrDest;
            arrDest = tmp;

            size = size * 2;

            System.out.println(arrayToString(arrSrc));
        }
    }

    private static void merge(int[] arr1, int arr1Start, int[] arr2, int arr2Start, int[] receiver, int receiverStart, int size) {
        int index1 = arr1Start;
        int index2 = arr2Start;

        int arr1End = Math.min(arr1Start + size, arr1.length);
        int arr2End = Math.min(arr2Start + size, arr2.length);

        int iterationCount = arr1End - arr1Start + arr2End - arr2Start;

        for (int i = receiverStart; i < receiverStart + iterationCount; i++) {
            if (index1 < arr1End && (index2 >= arr2End || arr1[index1] < arr2[index2])) {
                receiver[i] = arr1[index1];
                index1++;
            } else {
                receiver[i] = arr2[index2];
                index2++;
            }
        }

    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}