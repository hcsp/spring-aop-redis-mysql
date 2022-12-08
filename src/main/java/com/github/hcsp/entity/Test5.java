package com.github.hcsp.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        System.out.println(f(5));
        System.out.println(sum(Arrays.asList(1, 2, 3)));
    }

    public static int f(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * f(n - 1);
        }
    }

    public static int sum(List<Integer> list) {
        if(list.isEmpty()) {
            return 0;
        }
        return list.get(0) + sum(list.subList(1, list.size()));
    }

}
