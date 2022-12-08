package com.github.hcsp.entity;

import java.util.Arrays;

public class Test7 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }

        }
    }

    public static void swap(int[] x, int j, int i) {
        int t = x[i];
        x[i] = x[j];
        x[j] = t;


    }

}
