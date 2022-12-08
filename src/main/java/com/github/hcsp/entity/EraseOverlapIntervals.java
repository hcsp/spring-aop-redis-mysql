package com.github.hcsp.entity;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] interval) {
        if (interval.length == 0) {
            return 0;
        }
        Arrays.sort(interval, Comparator.comparingInt(o -> o[1]));

        int count = 0;
        int[] current = interval[0];
        for (int i = 1; i < interval.length; i++) {
            if (interval[i][0] < current[1]) {
                count++;
            } else {
                current = interval[i];
            }

        }
        return count;
    }

}
