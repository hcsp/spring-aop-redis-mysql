package com.github.hcsp.entity;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(calculate(new int[]{1, 2, 3, 4, 5}, 6));
    }

    public static int calculate(int[] array, int x) {
        return calculate(array, x, 0, array.length - 1);
    }

    public static int calculate(int[] array, int x, int start, int end) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            int midValue = array[mid];
            if(x<midValue){
                end = mid -1;
            } else if(x>midValue) {
                start = mid +1;
            }else {
                return mid;
            }
        }
        return -1;
//        int mid = (start + end) >>> 1;
//        if (end < start) {
//            return -1;
//
//        } else if (x == array[start]) {
//            return start;
//        } else if (x == array[mid]) {
//            return mid;
//        } else if (x == array[end]) {
//            return end;
//        } else if (x < array[mid] && x > array[start]) {
//            return calculate(array, x, start + 1, mid - 1);
//
//        } else {
//            return calculate(array, x, mid + 1, end - 1);
//        }
    }
}
