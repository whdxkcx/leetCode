package Bishi.Tencent;

import java.util.Scanner;

public class Main1 {
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            System.out.println(minIntLcm(n));
        }

        public static int minIntLcm(int n){
             int i=1;
             int maxN=maxYn(n+i);
             int maxM=maxYm(n,n+i);
             while(maxN!=maxM) {
                 i++;
                 maxN=maxYn(n+i);
                 maxM=maxYm(n,n+i);
             }
             return n+i;
        }

        public static int maxYn(int m){
            int sum=1;
            for(int i=2;i<=m;i++){
                int temp=YofAandB(i, sum);
                sum=sum*i/temp;
            }
            return sum;
        }
        public static int maxYm(int n,int m){
            int sum=n+1;
            for(int i=n+1;i<=m;i++){
                int temp=YofAandB(i, sum);
                sum=(sum*i)/temp;
            }
            return sum;
        }
        public static int YofAandB(int a,int b){
            while(true){
                int c=a%b;
                if(c==0) break;
                a=b;
                b=c;
            }
            return b;
        }


}
