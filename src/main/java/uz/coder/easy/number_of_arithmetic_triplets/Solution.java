package uz.coder.easy.number_of_arithmetic_triplets;

import uz.coder.Main;

import java.util.Arrays;

public class Solution {
    public  static int arithmeticTriplets(int[] nums, int diff) {

        int res = 0;
        int res1 = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j])==diff) res++;
            }
            res1 = Math.max(res1, res);
        }
        return res1;
    }

    public static void main(String[] args) {
        System.out.println(arithmeticTriplets(new int[]{0,1,4,6,7,10},3));
    }
}
