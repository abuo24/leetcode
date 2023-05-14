package uz.coder.medium.spiral_matrix_ii;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public static int[][] generateMatrix(int n) {
        int row=0,rowMax=n,column=0,columnMax=n, counter=0;
        int[][] mat = new int[n][n];

        while(row<=rowMax && column<=columnMax){

            for (int i=column; i<columnMax; i++){
                mat[row][i] = ++counter;
            }

            row++;
            for (int j=row; j<rowMax; j++){
                mat[j][columnMax-1] = ++counter;
            }
            columnMax--;

            for (int i=columnMax-1; i>=column; i--){
                mat[rowMax-1][i] = ++counter;
            }

            rowMax--;
            for (int j=rowMax-1; j>=row; j--){
                mat[j][column] = ++counter;
            }

            column++;

        }

        return mat;

    }
    public static void main(String[] args) {
       Arrays.stream(generateMatrix(3)).forEach(ints -> {
           System.out.printf(Arrays.toString(ints));
       });
    }
}
