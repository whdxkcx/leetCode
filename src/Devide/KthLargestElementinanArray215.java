package Devide;

public class KthLargestElementinanArray215 {
    public int findKthLargest(int[] nums, int k) {
          int len=nums.length-1;
          return findKLthQuikSort(nums,0,len,k);

    }
    public int findKLthQuikSort(int[] nums,int l,int h,int k){
        if(l>=h)
            return nums[l];
        int low=l;
        int high=h;
        int key=nums[l];

        while(low<high){
            while(low<high&&nums[high]<=key)
                high--;
            if(low<high)
                nums[low]=nums[high];
            while(low<high&&nums[low]>=key)
                low++;
            if(low<high)
                nums[high]=nums[low];
        }
        nums[low]=key;

        if(k==low+1)
            return nums[low];
        else if(k<low+1)
            return findKLthQuikSort(nums,l,low-1,k);
        else
            return findKLthQuikSort(nums,low+1,h,k);
    }

}
