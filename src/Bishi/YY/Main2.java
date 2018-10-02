package Bishi.YY;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int dp[]=new int[n+1];
        dp[1]=2;
        dp[2]=3;
        for(int i=3;i<=n;i++){
            if(i%2==0)
                dp[i]=dp[i-1]+dp[i-2];
            else
                dp[i]=dp[i-1]+dp[i-2]+find(i,(i+1)/2)-find(i-2,(i+1)/2-1);
        }
        System.out.println(dp[n]);
    }
    public static int find(int n,int m){
       if(n%2==0) return 2;
       else return 1;
    }

    public static int   fun(int n){
        int sum=1;
        for(int i=2;i<=n;i++){
            sum=sum*i;
        }
        return sum;
    }
}
