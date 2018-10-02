package DoublePoint;

import java.util.Scanner;

public class TrappingRainWater42 {
    public  static void  main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String sAr[]=s.split(",");
        int h[]=new int[sAr.length];
        for(int i=0;i<sAr.length;i++)
            h[i]=Integer.parseInt(sAr[i]);
        System.out.println(getWater(h));
    }
    public static  int getWater(int[] height) {
        int left_max=0,right_max=0;
        int left=0,right=height.length-1,ans=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=left_max){
                    left_max=height[left];
                }
                else{
                    ans+=(left_max-height[left]);
                }
                left++;
            }
            else{
                if(height[right]>=right_max){
                    right_max=height[right];
                }
                else{
                    ans+=(right_max-height[right]);
                }
                right--;
            }
        }
        return ans;
    }

}
