package Bishi;

import java.util.Arrays;
import java.util.Scanner;

public class food {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int p=in.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        if(n<=0||p<=0) return;
        in.nextLine();
        for(int i=0;i<m;i++){
            String s[]=in.nextLine().trim().split(" ");
            if(s[0].equals("A")) a[Integer.parseInt(s[1])-1]++;
            else a[Integer.parseInt(s[1])-1]--;
        }
        int b[]=new int[n];
        for(int i=0;i<n;i++){
            b[i]=a[i];
        }
        Arrays.sort(b);
        for(int i=n-1;i>=0;i--){
            if(b[i]==a[p-1])  {
                System.out.println(n-i);
                break;
            }
        }
    }
}
