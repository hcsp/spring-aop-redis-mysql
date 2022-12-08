package com.github.hcsp.entity;

public class Coin {
    static int[] coins = new int[]{0, 1, 5, 10, 25};

    static int f(int k, int n) {
        if (k == 1) {
            return 1;
        }
        int currentCoin = coins[k];
        int result = 0;
        for (int i = 0; n - i * currentCoin >= 0; i++) {
            result += f(k - 1, n - i * currentCoin);
        }
        return result;
    }

    static int howManyCoins(int n) {
        return f(4, n);
    }

    public static void main(String[] args) {
//        System.out.println(howManyCoins(10));
        System.out.println(howManyCoins2(10));
    }

    public static int howManyCoins2(int n) {
        int[] result = new int[n + 1];

        result[0] = 1;
//        for (int i = 1; i < n + 1; i++) {
//            result[i] = 0;
//
//        }
        for (int j = 1; j < coins.length; j++) {
            int k = coins[j];
            for (int i = k; i <= n; i++) {
//                result[i] = (result[i] + result[i - coin]) % 1000000007;
                result[i] = result[i] + result[i - k];
            }
        }
        return result[n];
    }

}
