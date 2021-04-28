package com.company;

public class Main {
    public static void main(String[] params) {
        int[] array = new int[]{54, 64, 34, 79, 43, 1, 93, 53, 32, 71, 24, 39, 36};
        System.out.println("Введеный массив");
        System.out.println(arrayToString(array));
        System.out.println("Результат сортировки");
        System.out.println(arrayToString(mergeSort(array)));
    }

    public static int[] mergeSort(int[] array) {
        int[] first = array;
        int[] second = new int[array.length];

        for(int size = 1; size < array.length; size *= 2) {
            for(int i = 0; i < array.length; i += 2 * size) {
                merge(first, i, first, i + size, second, i, size);
            }

            int[] link = first;
            first = second;
            second = link;
        }

        return first;
    }

    private static void merge(int[] first, int firstStart, int[] second, int secondStart, int[] ready, int readyStart, int size) {
        int index1 = firstStart;
        int index2 = secondStart;
        int firstEnd = Math.min(firstStart + size, first.length);
        int secondEnd = Math.min(secondStart + size, second.length);
        int iterationCount = firstEnd - firstStart + secondEnd - secondStart;

        for(int i = readyStart; i < readyStart + iterationCount; ++i) {
            if (index1 >= firstEnd || index2 < secondEnd && first[index1] >= second[index2]) {
                ready[i] = second[index2];
                ++index2;
            } else {
                ready[i] = first[index1];
                ++index1;
            }
        }

    }

    private static String arrayToString(int[] array) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[");

        for(int i = 0; i < array.length; ++i) {
            if (i > 0) {
                stringbuilder.append(", ");
            }

            stringbuilder.append(array[i]);
        }

        stringbuilder.append("]");
        return stringbuilder.toString();
    }

}
