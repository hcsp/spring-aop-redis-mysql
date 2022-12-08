package com.github.hcsp.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen {
    public static void main(String[] args) {
        System.out.println(new Queen().solveNQueens(8).size());
    }

    public static List<List<String>> solveNQueens(int n) {
        return solveNQueens(n, n);
    }

    public static List<List<String>> solveNQueens(int n, int x) {

        if (x == 1) {
            List<List<String>> solutionOfFirstRow = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solutionOfFirstRow.add(Arrays.asList(queenAt(i + 1, n)));

            }
            return solutionOfFirstRow;
        }

        List<List<String>> resultOfXMinus1 = solveNQueens(n, x - 1);
        List<List<String>> result = new ArrayList<>();
        for (List<String> solutionOfXMinus1 : resultOfXMinus1) {
            for (int i = 1; i <= n; i++) {
                if (isValid(solutionOfXMinus1, i, x)) {
                    List<String> solution = new ArrayList<>(solutionOfXMinus1);
                    solution.add(queenAt(i, n));
                    result.add(solution);
                }
            }
        }
        return result;
    }

    private static boolean isValid(List<String> solutionOfXMinus1, int i, int x) {
        for (int rowIndex = 0; rowIndex < solutionOfXMinus1.size(); rowIndex++) {
            String row = solutionOfXMinus1.get(rowIndex);
            int queenRowIndex = rowIndex + 1;
            int queenColIndex = row.indexOf("Q") + 1;
            if (queenColIndex == i) {
                return false;
            }
            if (queenColIndex + queenRowIndex == x + i) {
                return false;
            }
            if (queenRowIndex - queenColIndex == x - i) {
                return false;
            }

        }
        return true;

    }

    private static String queenAt(int i, int n) {
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < i - 1; j++) {
            str.append(".");

        }
        str.append("Q");
        for (int j = 0; j < n - i; j++) {
            str.append(".");

        }
        return str.toString();

    }
}
