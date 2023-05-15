package uz.coder.medium.search_a_2d_matrix;

import java.util.Arrays;

public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int index = -1;
        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][matrix[0].length - 1] > target) {
                index = mid;
                high = mid - 1;
            } else if (matrix[mid][matrix[0].length - 1] < target) {
//              we cannot put index=mid; statement to here. Because we can identify properly middle value
                low = mid + 1;
            } else {
                return true;
            }
        }
        System.out.println(index);

        if (index == -1) return false;

        int[] arr = matrix[index];

        low = 0;
        high = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 17));
    }
}
