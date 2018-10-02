package Array;

public class ProductofArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int dp[] = new int[nums.length];
        int sums = 1;
        int count = 0;//记录0的个数
        int index = -1;//记录0的索引
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                index = i;
                if (count >= 2) break;
                continue;
            }
            sums = nums[i] * sums;
        }
        if (count == 0)
            for (int i = 0; i < nums.length; i++) {
                dp[i] = sums / nums[i];
            }
        else if (count == 1)
            for (int i = 0; i < nums.length; i++) {
                if (i == index)
                    dp[i] = sums;
                else
                    dp[i] = 0;
            }
        return dp;
    }
}
