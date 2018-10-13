package Bishi;

import java.util.Scanner;

public class YueSheFu {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(yuShefu(n,3));
    }

    public static int yuShefu(int n,int m){
        int sum=0;
        for(int i=2;i<=n;i++)sum=(sum+m%i)%i;
        return sum+1;
    }
}
