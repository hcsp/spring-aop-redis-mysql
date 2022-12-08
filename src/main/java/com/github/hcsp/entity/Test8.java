package com.github.hcsp.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test8 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 5, 4, 3, 3, 2, 1, 0);
        System.out.println(fastSort(list));
    }


    public static List<Integer> fastSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        List<Integer> less = new ArrayList<>(), greater = new ArrayList<>();
        List<Integer> pivotList = new ArrayList<>();
        Integer pivot = list.get(0);
        for (Integer i : list) {
            if (i < pivot) {
                less.add(i);
            } else if (i.equals(pivot)) {
                pivotList.add(i);
            } else {
                greater.add(i);
            }

        }

        List<Integer> result = new ArrayList<>();
        result.addAll(fastSort(less));
        result.addAll(pivotList);
        result.addAll(fastSort(greater));
        return result;
    }

}
