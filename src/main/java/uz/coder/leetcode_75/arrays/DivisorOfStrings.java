package uz.coder.leetcode_75.arrays;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 */
public class DivisorOfStrings {

    public static String gcdOfStrings(String str1, String str2) {
        int index = 1;
        String res = "", iterator = "";
        while (index <= str2.length()) {
            iterator = str2.substring(0, index);
            if (str1.replaceAll(iterator, "").length() == 0
                    && str2.replaceAll(iterator, "").length() == 0) {
                res = iterator;
            }
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
    }
}
