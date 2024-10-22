package uz.coder.leetcode_75.arrays;

/**
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MergeStrings {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder("");
        int index = 0;
        while ((word1.length() > word2.length() ? word1 : word2).length() > index) {
            if (word1.length() > index) {
                res.append(word1.charAt(index));
            }
            if (word2.length() > index) {
                res.append(word2.charAt(index));
            }
            index++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abs", "pqrss"));
//        TC: O(N)
//        MC: O(1)
    }
}
