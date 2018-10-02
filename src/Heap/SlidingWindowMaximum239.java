package Heap;

import java.util.ArrayDeque;

public class SlidingWindowMaximum239 {
    public  static int[] maxSlidingWindow(int[] nums, int k) {
        //混动窗口--双端队列
        //思路：
        //1.双端队列的队首存储最大元素。
        //2.新元素从队尾开始比较，比它的小的就删除掉，直到没有比它小的元素了，再把这个元素插入队尾。
        //3.把每次滑动窗口的最大值，也就是队首元素存入队列。
        int  res[]=new int[nums.length-k+1];
        if(k==0)  return new int[0];
        ArrayDeque<Integer> dq=new ArrayDeque();
        int j=0;
        for(int i=0;i<nums.length;i++){
            while((!dq.isEmpty())&&(nums[dq.peekLast()]<=nums[i])){
                dq.pollLast();
            }
            dq.add(i);
            if(i>=k-1) {
                if(dq.peekFirst()<i+1-k)  dq.pollFirst();
                res[j++]=nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
