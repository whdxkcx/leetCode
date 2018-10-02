package Bishi.Tencent;

import java.util.Scanner;

public class Main3 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            int a=0,b=0,c=0;
            for(int i=0;i<t;i++){
                a=in.nextInt();
                b=in.nextInt();
                c=in.nextInt();
                System.out.println(isGood(a,b,c));
            }
        }

        public static String isGood(int a,int b,int c){
            int i=1;
            while(true){
                int y=a*i%b;
                if(y==c) return "YES";
                if(y==0) break;
            }
            return "NO";
        }

   }

