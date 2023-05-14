package uz.coder.medium.spiral_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int row = 0, rowMax = matrix.length, column = 0, columnMax = matrix[0].length, counter = 0;
        int[][] mat = new int[rowMax][columnMax];

        while (row <= rowMax && column <= columnMax) {

            for (int i = column; i < columnMax; i++) {
                res.add(matrix[row][i]);
            }

            row++;
            for (int j = row; j < rowMax; j++) {
                res.add(matrix[j][columnMax - 1]);
            }
            columnMax--;

            if (row < rowMax && column < columnMax) {
                for (int i = columnMax - 1; i >= column; i--) {
                    res.add(matrix[rowMax - 1][i]);
                }
            }
            rowMax--;
            if (row < rowMax && column < columnMax) {
                for (int j = rowMax - 1; j >= row; j--) {
                    res.add(matrix[j][column]);
                }
            }
            column++;


        }

        if (res.size() > matrix.length * matrix[0].length) {

            List<Integer> test = new ArrayList<>();

            for (int i=0; i<matrix.length * matrix[0].length;i++){
                test.add(res.get(i));
            }

            res = test;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}}));
    }
}
