package com.github.hcsp.entity;

import java.util.Arrays;

public class Test9 {
    public static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right);
        return storeIndex;
    }

    public static void fastSortPartition(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right, right);

        fastSortPartition(array, left, pivotIndex - 1);
        fastSortPartition(array, pivotIndex + 1, right);

    }

    public static void fastSortInPlace(int[] array) {
        fastSortPartition(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 0, 7, 434, 4, 56, 6, 7, 0};
        fastSortInPlace(array);
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] x, int j, int i) {
        int t = x[i];
        x[i] = x[j];
        x[j] = t;


    }


}
