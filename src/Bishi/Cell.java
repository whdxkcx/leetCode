package Bishi;



import java.util.Scanner;

public class Cell {
    public static  void main(String[] args){
        Scanner in=new Scanner(System.in);
        int  k=in.nextInt();
        int b=in.nextInt();
        int n=in.nextInt();
        int t=in.nextInt();
        int z=1;
        int count=0;
        while(z<=t) {
            count++;
            z = z * k + b;
        }
        System.out.println(n-count+1);
    }
}
