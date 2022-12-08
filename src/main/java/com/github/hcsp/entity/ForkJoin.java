package com.github.hcsp.entity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(sumParallel(new int[]{1,2,3,4,5,5}));
    }

    public static int sumParallel(int[] array) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int result = forkJoinPool.submit(new SubArray(array, 0, array.length - 1)).get();
//        System.out.println(result);
        return result;
    }

    static class SubArray extends RecursiveTask<Integer> {
        private int[] array;
        private int start;
        private int end;

        public SubArray(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (start == end) {
                return array[start];
            }
            if (start > end) {
                return 0;
            }
            int mid = (start + end) / 2;
            SubArray leftSubArray = new SubArray(array, start, mid - 1);
            SubArray rightSubArray = new SubArray(array, mid + 1, end);
            leftSubArray.fork();
            rightSubArray.fork();
            int leftSum = leftSubArray.join();
            int rightSUm = rightSubArray.join();
            return leftSum + array[mid] + rightSUm;

        }
    }
}
