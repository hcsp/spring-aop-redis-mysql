package com.github.hcsp.dao;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] array1 = new int[]{-3,-2,-1,-2,-3,-5};
        System.out.println(maxSubArray(array));
        System.out.println(maxSubArray(array1));
    }

    public static int maxSubArray(int[] array) {
        return maxSubArray(array, 0, array.length - 1);

    }

    public static int maxSubArray(int[] array, int start, int end) {

        if (start == end) {
            return array[start];
        } else if (start > end) {
            return 0;
        } else if (start + 1 == end) {
            if (array[start] < 0 || array[end] < 0) {
                return Math.max(array[start], array[end]);
            } else {
                return array[start] + array[end];
            }

        }
        int mid = (start + end) / 2;

        int leftMax = maxSubArray(array, start, mid - 1);
        int rightMax = maxSubArray(array, mid + 1, end);
        int midMax = getMaxMid(array, start, end, mid);
        return Math.max(Math.max(leftMax, rightMax), midMax);


    }

    public static int getMaxMid(int[] array, int start, int end, int mid) {
        int leftSum = 0;
        int leftMax = Integer.MIN_VALUE;
        for (int i = mid; i >= start; i--) {
            leftSum += array[i];
            if (leftSum > leftMax) {
                leftMax = leftSum;

            }
        }
        int rightSum = 0;
        int rigthMax = Integer.MIN_VALUE;
        for (int i = mid; i <= end; i++) {
            rightSum += array[i];
            if (rightSum > rigthMax) {
                rigthMax = rightSum;
            }

        }

        return leftMax - array[mid] + rigthMax;

    }

}
