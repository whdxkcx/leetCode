package Array;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        int len=nums.length;
        int i=0,j=len-1;
         while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) i=mid+1;
            else j=mid-1;
        }
        return i;
    }
}
