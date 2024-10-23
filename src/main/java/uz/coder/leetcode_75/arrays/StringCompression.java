package uz.coder.leetcode_75.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 */
public class StringCompression {

    public static int compress(char[] chars) {
        // char[] newArray = new char[chars.length];
        int counter = 0;
        int lastIndex = 0;
        Map<Integer, String> res = new HashMap<>();
        List<Character> elements = new ArrayList<>();
        if (chars.length == 0 || chars.length == 1) return chars.length;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[lastIndex] && i == chars.length - 1) {

                elements.add(chars[lastIndex]);
                // a,a,a,b
                res.put(counter, String.valueOf(i - lastIndex));
            } else if (chars[i] == chars[lastIndex]) {
            } else {
                // a,a,a,b
                elements.add(chars[lastIndex]);
                res.put(counter, String.valueOf(i - lastIndex));
                lastIndex = i;
                counter++;
                if (i == chars.length - 1) {
                    elements.add(chars[lastIndex]);
                    // a,a,a,b
                    res.put(counter, String.valueOf(i - lastIndex));
                    lastIndex = i;
                    counter++;
                }
            }
        }
        System.out.println(elements);
        int index = 0;
        String resString = "";
        for (int i = 0; i < elements.size(); i++) {
            resString += elements.get(i).toString();
            if ((!(res.get(index).equals("1") || res.get(index).equals("0")) ? res.get(index).length() : 0) > 0) {
                resString += res.get(index);
            }
            index++;
        }
        chars = resString.toCharArray();
        System.out.println(chars);

        // Iterate through the char array using a for loop
        for (int i = 0; i < resString.toCharArray().length; i++) {
            // Access each character by its index
            chars[i] = resString.toCharArray()[i];
        }
        System.out.println(chars);
        return res.keySet().size() + res.values().stream()
                .map(item -> !(item.equals("1") || item.equals("0")) ? item.length() : 0)
                .reduce(Integer::sum).get();
    }

    public static void main(String[] args) {
//        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'b'}));
        System.out.println(compress2(new char[]{'a', 'a', 'b', 'b', 'a'}));
        System.out.println(compress2(new char[]{'a', 'b', 'b', 'b'}));
        System.out.println(compress2(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(compress2(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress2(new char[]{'a', 'b', 'b', 'b'}));
        System.out.println(compress2(new char[]{'a', 'b'}));
    }


    public static int compress2(char[] chars) {
        // char[] newArray = new char[chars.length];
        int index = 0;
        if (chars.length == 0 || chars.length == 1) return chars.length;
        int i = 0;
        int n = chars.length;
        while (i < n) {
            int temp = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] != chars[i]) {
                    temp = j - i;
                    break;
                } else if (j == chars.length - 1) {
                    temp = j - i + 1;
                }
            }
            chars[index++] = chars[i];
            if (temp != 1) {
                char[] newArray = String.valueOf(temp).toCharArray();
                for (char c : newArray) {
                    chars[index++] = c;
                }
            }
            i += temp;
        }
        System.out.println(chars);
        return index;
    }
}

