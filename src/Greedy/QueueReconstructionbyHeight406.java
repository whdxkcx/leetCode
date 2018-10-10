package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight406 {
    //Hence to obtain the final results, we just need to construct an empty list res, and starting from the left, insert each element [i,j] in people_sorted to position j in res (Latter insertions of [i',j'] won't affect j because either i' < i, or i' == i and j' > j). The time complexity of the algorithm is O(n^2): We loop over people once, and each insertion is an O(n) operation.
    public int[][] reconstructQueue(int[][] people) {
        int n=people.length;
        Arrays.sort(people,(a,b)->a[0]!=b[0]?b[0]-a[0]:a[1]-b[1]);
        List<int[]>  list=new ArrayList();
        for(int[] person : people) list.add(person[1],person);
        return list.toArray(new int[people.length][]);
    }
}
