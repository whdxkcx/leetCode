package DoublePoint;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
         for(int lastNoZoreNumber=0,cur=0;cur<nums.length;cur++){
             if(nums[cur]!=0)   swap(nums,lastNoZoreNumber++,cur);
         }
    }

    public void swap(int  a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;

    }
}
