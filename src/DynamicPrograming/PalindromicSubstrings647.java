package DynamicPrograming;

public class PalindromicSubstrings647 {
    public static void main(String[] args){
        PalindromicSubstrings647 p=new PalindromicSubstrings647();
       System.out.println( p.countSubstrings("aaaaa"));
    }
    //从后往前遍历，递推公式为：dp[i][j] = s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1]);
    public int countSubstrings(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        int res = len;
        for (int i = len-2; i >=0; i--)
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1]);
                if (dp[i][j]) res++;
            }
        return res;
    }
}
