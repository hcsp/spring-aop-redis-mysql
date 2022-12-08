package com.github.hcsp.entity;

public class TestTree {
    public static void main(String[] args) {
        System.out.println(f(3));
    }

    public static int f(int n) {
        if(n==1) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += result[j - 1] * result[i - j];

            }
            result[i] = sum;

        }
        return result[n];

    }

}
