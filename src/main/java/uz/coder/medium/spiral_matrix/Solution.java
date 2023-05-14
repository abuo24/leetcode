package uz.coder.medium.spiral_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int row=0,rowMax=matrix.length,column=0,columnMax=matrix[0].length, counter=0;
        int[][] mat = new int[rowMax][columnMax];

        while(row<=rowMax && column<=columnMax){

            for (int i=column; i<columnMax; i++){
                res.add(matrix[row][i]);
            }

            row++;
            for (int j=row; j<rowMax; j++){
                res.add(matrix[j][columnMax-1]);
            }
            columnMax--;

            for (int i=columnMax-1; i>=column; i--){
                res.add(matrix[rowMax-1][i]);
            }

            rowMax--;
            for (int j=rowMax-1; j>=row; j--){
                res.add(matrix[j][column]);
            }

            column++;


        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(uz.coder.medium.spiral_matrix_ii.Solution.generateMatrix(3)));
    }
}
