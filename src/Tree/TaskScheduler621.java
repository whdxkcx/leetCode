package Tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskScheduler621 {
    //先统计任务出现频次，然后排序。按最大的出现频次分模块。
    //What happens when there are not sufficient slots between highest frequency characters for remaining less frequent characters? This was my main concern when I had tried to solve this problem with same logic. But I failed to observe that in that case, mere round-robin scheduling will be sufficient to maintain required separation constraint, requiring as many cycles as there are tasks.
    public int leastInterval(char[] tasks, int n) {
        int c[]=new int[26];
        for(char ch:tasks)
            c[ch-'A']++;
        Arrays.sort(c);
        int i=25;
        while(i>=0&&c[i]==c[25]) i--;
        //当最大频次的模块之间没有足够的间隙来插入这些值时，之间循环遍历就可以了，也就是花费任务的长度的时间。
        //因为当我模块的间隙被填满之后，我可以选择顺序地在各个模块之间插入值。
        //For example, the task is AAABBCCD, n = 2:
        //First : AXXAXXA
        //Next : ABXABXA
        //Next : ABCABCA
        //Finally(which is your concern) : ABCDABCA or ABCABCDA
        //
        //In this case, the result is same as the length of task.
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
