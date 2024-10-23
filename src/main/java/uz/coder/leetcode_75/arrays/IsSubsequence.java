package uz.coder.leetcode_75.arrays;

/**
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        char[] a = t.toCharArray();
        char[] b = s.toCharArray();
        int i = 0, j = 0;
        while (i < b.length) {
            while (j < a.length) {
                if (a[j] == b[i]) {
                    if (i == b.length - 1) {
                        return true;
                    }
                    j++;
                    break;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "abcabc"));
        System.out.println(isSubsequence("abd", "abcabc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
