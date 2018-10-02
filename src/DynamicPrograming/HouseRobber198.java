package DynamicPrograming;

public class HouseRobber198 {
    public int rob(int[] nums) {
        int s1=0,s2=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0)  s1+=nums[i];
            else s2+=nums[i];
        }
        return Math.max(s1,s2);
    }
}
