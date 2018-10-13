package Greedy;

import java.util.Map;
import java.util.TreeMap;

public class AdvantageShuffle870 {
    //主要使用TreeMap的getHigherEntry函数。找到比B当前元素大的最小值，若没有比它大的，就用最小值来对它（田忌赛马）。
    public int[] advantageCount(int[] A, int[] B) {
        // the tree map stores <value, count> pairs of array A
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // for each value in B, get the A entry with smallest higher key or the smallest key if not exist
        int[] res = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            Map.Entry<Integer, Integer> matchingEntry = map.higherEntry(B[i]);
            if (matchingEntry == null) {
                matchingEntry = map.firstEntry();
            }

            res[i] = matchingEntry.getKey();
            if (matchingEntry.getValue() == 1) {
                map.remove(matchingEntry.getKey());
            } else {
                map.put(matchingEntry.getKey(), matchingEntry.getValue() - 1);
            }
        }

        return res;
    }
}
