package com.github.hcsp.entity;


import java.io.*;
import java.util.HashMap;

public class Test4 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("1.csv"));
        for (int i = 0; i < 16; i++) {
            Counter counter = new Counter();
            counter.f(i);
            bw.write("" + i + "," + counter.value + "\n");

        }
        bw.flush();
    }

    static class Counter {

        int value = 0;
        HashMap<Integer,Integer> cache = new HashMap<>();

        public int f(int n) {
            if(cache.containsKey(n)) {
                return cache.get(n);
            }
            if (n == 0 || n == 1) {
                return 1;
            } else {
                value++;
                int result = f(n - 1) + f(n - 2);
                cache.put(n,result);
                return result;
            }
        }
    }
}
