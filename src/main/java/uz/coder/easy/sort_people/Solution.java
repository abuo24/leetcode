package uz.coder.easy.sort_people;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        String[] res = new String[map.values().size()];
        AtomicInteger counter = new AtomicInteger(map.values().size());
        map.forEach((key, value) -> {
            res[counter.decrementAndGet()] = value;
        });
        return res;
    }

}
