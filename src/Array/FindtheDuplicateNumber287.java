package Array;

public class FindtheDuplicateNumber287 {
    //先对所有的元素减一，然后从数组末尾开始，必然形成一个单环单链表。求出环的入口就是重复的数字。
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<nums.length;i++) nums[i]--;
        int slow = n-1;
        int fast = n-1;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        slow = n-1;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow+1;
    }
}
