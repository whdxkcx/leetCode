package Bishi;

import com.sun.xml.internal.ws.api.pipe.SyncStartForAsyncFeature;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class LuckyID {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();

        System.out.println(countOfStep(s));
    }

    public  static int  countOfStep(String s){
          int count=0;
          char ca[]=s.toCharArray();
          int front[]=new int[3];
          int after[]=new int[3];
          int s1=0,s2=0;
          for(int i=0;i<3;i++){
              front[i]=Integer.parseInt(s.substring(i,i+1));
              s1+=front[i];
              after[i]=Integer.parseInt(s.substring(i+3,i+4));
              s2+=after[i];
          }
           Arrays.sort(front);
        Arrays.sort(after);
          if(s1>s2)
              count=oneStep(s2,after,s1,front);
          else
              count=oneStep(s1,front,s2,after);
          return count;
    }

    public static int oneStep(int s1,int[] front,int s2,int[] after){
        int count=0;
        for(int i=2;i>=0;i--){
            front[i]=9-front[i];
        }
        int i=0,j=2;
        while(s1<s2&&i<3&&j>=0){
            count++;
            if(front[i]<after[j]) {
                s2 -= after[j];
                j--;
            }
            else {
                s1+=front[i];
                i++;
            }
        }
        return count;
    }
}
