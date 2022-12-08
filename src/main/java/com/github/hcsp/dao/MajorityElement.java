package com.github.hcsp.dao;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MajorityElement {
    public static void main(String[] args) {
//  /      int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] array1 = new int[]{2, 2, 3, 3, 0, 3, 1, 1};
//        int[] array2 = new int[]{1, 2, 2, 3, 4, 2, 3, 3};
//        System.out.println(majorityElement(array));
        System.out.println(majorityElement(array1));

    }

    public static int majorityElement(int[] array) {
        return majorityElement(array, 0, array.length - 1);
    }

    public static int majorityElement(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        if (start == end) {
            return array[start];
        }
        if (start + 1 == end) {
//            Long a = Arrays.stream(array, 0, array.length).filter(i -> i == array[start]).count();
//            Long b = Arrays.stream(array, 0, array.length).filter(i -> i == array[end]).count();
//            if (a > b) {
//                return array[start];
//            } else if (a < b) {
//                return array[end];
//            } else {
//                return array[start];
//            }
            return array[start];
        }

        int leftMajority = majorityElement(array, start, mid - 1);
        int rightMajority = majorityElement(array, mid, end);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        long leftCount = Arrays.stream(array, 0, array.length).filter(i -> i == leftMajority).count();
        long rightCount = Arrays.stream(array, 0, array.length).filter(i -> i == rightMajority).count();

        if (leftCount > rightCount) {
            return leftMajority;
        } else {
            return rightMajority;
        }


    }
}
