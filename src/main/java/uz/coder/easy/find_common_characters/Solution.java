package uz.coder.easy.find_common_characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countMatches("salom","s"));
    }
    public List<String> commonChars(String[] words) {
        Map<String, Integer> res = new HashMap<>();
        if (words.length > 0) {
            for (char word : words[0].toCharArray()) {
                res.put(String.valueOf(word), res.getOrDefault(String.valueOf(word), 0) + 1);
            }
        }

        for (int i = 1; i < words.length; i++) {
            List<String> needToRemove = new ArrayList<>();
            Map<String, Integer> needToRemove2 = new HashMap<>();
            int finalI = i;
            res.forEach((k, v) -> {
                if (!words[finalI].contains(k)) {
                    needToRemove.add(k);
                }
                if (countMatches(words[finalI], k) < v) {
                    needToRemove2.put(k, countMatches(words[finalI], k));
                }
            });
            res.putAll(needToRemove2);
            for (String s : needToRemove) {
                res.remove(s);
            }
        }
        List<String> realRes = new ArrayList<>();
        res.forEach((k, v) -> {
            for (int i = 1; i <= v; i++) {
                realRes.add(k);
            }
        });
        return realRes;
    }

    public List<String> commonChars1(String[] words) {
        List<String> res = new ArrayList<>();


        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                boolean isGlobalFound = false;
                for (int k = 0; k < words.length; k++) {
                    if (i == k) continue;
                    boolean isFound = false;
                    boolean isSecondFound = false;
                    for (int l = 0; l < words[k].length(); l++) {
                        if (words[i].charAt(j) == words[k].charAt(l)) {
                            if (!isFound) {
                                isFound = true;
                            } else {
                                isSecondFound = true;
                            }
                        }
                    }
                    if (!isFound) {
                        isGlobalFound = false;
                        break;
                    } else {
                        isGlobalFound = true;
                    }
                }
                if (isGlobalFound) {
                    res.add(String.valueOf(words[i].charAt(j)));
                }
            }
        }

        return res;
    }

    public static boolean isDuplicate(String str, char el) {
        char[] carray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (carray[i] == carray[j] && carray[i] == el) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int countMatches(String line, String el) {
        return line.length() - line.replace(el, "").length();
    }
}
